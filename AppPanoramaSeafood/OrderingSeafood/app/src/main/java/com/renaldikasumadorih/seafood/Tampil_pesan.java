package com.renaldikasumadorih.seafood;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.renaldikasumadorih.seafood.Adapter.AdapterData;
import com.renaldikasumadorih.seafood.Model.ModelData;
import com.renaldikasumadorih.seafood.Util.AppController;
import com.renaldikasumadorih.seafood.Util.ServerAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tampil_pesan extends AppCompatActivity {
    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManajer;
    List<ModelData> mItems;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_pesan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerview = (RecyclerView) findViewById(R.id.pesanrecy);
        pd = new ProgressDialog(Tampil_pesan.this);
        mItems = new ArrayList<>();

        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);


        loadJson();


        mManajer = new LinearLayoutManager(Tampil_pesan.this,LinearLayoutManager.VERTICAL, false);
        mRecyclerview.setLayoutManager(mManajer);
        mAdapter = new AdapterData(Tampil_pesan.this,mItems);
        mRecyclerview.setAdapter(mAdapter);



    }

    private void loadJson() {
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();
        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.POST, ServerAPI.URL_DATA, null,
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
                                ModelData md = new ModelData();
                                md.setId(data.getString("id"));
                                md.setNama(data.getString("nama"));
                                md.setTlp(data.getString("tlp"));
                                md.setAlamat(data.getString("alamat"));
                                md.setFood(data.getString("food"));
                                md.setWaktu(data.getString("waktu"));
                                md.setStatus(data.getString("status"));
                                mItems.add(md);
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

}
