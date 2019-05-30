package com.renaldikasumadorih.seafood;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.renaldikasumadorih.seafood.Util.AppController;
import com.renaldikasumadorih.seafood.Util.ServerAPI;

import java.util.HashMap;
import java.util.Map;

public class pesan_food extends AppCompatActivity {
    EditText nama, tlp, alamat, food;
    Button btnpesan;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);

        nama = (EditText) findViewById(R.id.txtnama);
        tlp = (EditText) findViewById(R.id.txttlp);
        alamat = (EditText) findViewById(R.id.txtalamat);
        food = (EditText) findViewById(R.id.txtpesan);
        btnpesan = (Button) findViewById(R.id.btn_pesan);
        pd = new ProgressDialog(pesan_food.this);

        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kirimPesan();
            }
        });


    }
    private void kirimPesan(){
        pd.setMessage("Mengirim pesan...");
        pd.setCancelable(false);
        pd.show();

        StringRequest sendPesan = new StringRequest(Request.Method.POST, ServerAPI.URL_INSERT_PESAN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.cancel();
                        Toast.makeText(pesan_food.this, "Pesan Terkirim", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Toast.makeText(pesan_food.this, "Pesan gagal", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("nama", nama.getText().toString());
                map.put("tlp", tlp.getText().toString());
                map.put("alamat", alamat.getText().toString());
                map.put("food", food.getText().toString());

                return map;
            }
        };
        AppController.getInstance().addToRequestQueue(sendPesan);

    }

}
