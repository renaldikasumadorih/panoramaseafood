package com.renaldikasumadorih.seafood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.renaldikasumadorih.seafood.Adapter.AdapterFood;
import com.renaldikasumadorih.seafood.Model.ModelFood;
import com.renaldikasumadorih.seafood.Util.AppController;
import com.renaldikasumadorih.seafood.Util.ServerAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final String TAG = this.getClass().getName();

    Button btninsert, btninfo;
    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManajer;
    List<ModelFood> fitem;
    ProgressDialog pd;
    RequestQueue mRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        btninsert = (Button) findViewById(R.id.btn_pesan);
        btninfo = (Button) findViewById(R.id.btn_info);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerview = (RecyclerView) findViewById(R.id.foodrecy);
        pd = new ProgressDialog(MainActivity.this);
        fitem = new ArrayList<>();

        loadJson();

        mRequest = Volley.newRequestQueue(getApplicationContext());
        mManajer = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL, false);
        mRecyclerview.setLayoutManager(mManajer);
        mAdapter = new AdapterFood(MainActivity.this,fitem);
        mRecyclerview.setAdapter(mAdapter);


        FloatingActionButton btninsert = (FloatingActionButton) findViewById(R.id.btn_pesan);
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pesan_food.class);
                startActivity(intent);
            }
        });
        FloatingActionButton btninfo = (FloatingActionButton) findViewById(R.id.btn_info);
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Tampil_pesan.class);
                startActivity(intent);
            }
        });
    }

    private void loadJson() {
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();

        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.POST, ServerAPI.URL_DATA_FOOD, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        pd.cancel();
                        Log.d("volley" , "response : " + response.toString());
                        int i = -1 ;
                        while (i < response.length()) {
                            i++;
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelFood mf = new ModelFood();
                                mf.setId(data.getString("id"));
                                mf.setNama(data.getString("nama"));
                                mf.setStok(data.getString("stok"));
                                mf.setHarga(data.getString("harga"));
                                mf.setGambar(data.getString("gambar"));
                                mf.setDeskripsi(data.getString("deskripsi"));
                                fitem.add(mf);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Log.d("volley", "error : " + error.getMessage());
                    }
                });
        AppController.getInstance().addToRequestQueue(reqData);
    }
    boolean twice = false;
    @Override
    public void onBackPressed() {
        Log.d(TAG, "click");
        if(twice == true){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
        twice = true;
        Log.d(TAG, "twice : " + twice);
        //super.onBackPressed();
        Toast.makeText(this, "Sentuh lagi untuk KELUAR", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
                Log.d(TAG, "twice : " + twice);
            }
        }, 3000);

    }
}
