package com.example.push_notifications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {
    RequestQueue requestQueue;
    String token ;
    String email;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
         email = intent.getStringExtra("EMAIL_LOGIN");
         password = intent.getStringExtra("PASSWORD_LOGIN");


        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(
                new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.e("OLA", "Falied to get token :" + task.getException());
                            return;
                        }
                        token = task.getResult();
                        Log.e("OLA", "Token" + token);

                        Submit();
                    }
                }
        );
    }

    private void Submit() {

        String URL="https://mcc-users-api.herokuapp.com/add_reg_token";
        requestQueue= Volley.newRequestQueue(getApplicationContext());
        Log.d("TAG", "requestQueue: "+requestQueue);
        StringRequest stringRequest=new StringRequest(Request.Method.PUT, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject objres = new JSONObject(response);
                    Log.d("TAG", "onResponse: "+objres.toString());
                } catch (JSONException e) {
                    Log.d("TAG", "Server Error ");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", "onErrorResponse: "+error);
            }
        })
        {

            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                HashMap savedata = new HashMap();
                savedata.put("email",email);
                savedata.put("password",password);
                savedata.put("reg_token",token);
                return savedata;
            }
        };
        requestQueue.add(stringRequest);
    }
}

