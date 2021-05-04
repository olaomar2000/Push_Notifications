package com.example.push_notifications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    EditText editTextFristName;
    EditText editTextSecondName;
    EditText editTextEmail;
    EditText editTextPassword;

    String token = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFristName = findViewById(R.id.txt_FristName);
        editTextSecondName = findViewById(R.id.txt_SecondName);
        editTextPassword = findViewById(R.id.txt_Password);
        editTextEmail = findViewById(R.id.txt_Email);

    }


    public void singup(View v) {

        String data="{"+
                "\"firstName\""   + ":"+  "\""+editTextFristName.getText().toString()+"\","+
                "\"secondName\""  + ":"+  "\""+editTextSecondName.getText().toString()+"\","+
                "\"email\""       + ":"+  "\""+editTextEmail.getText().toString()+"\","+
                "\"password\""    + ":"+   "\""+editTextPassword.getText().toString()+"\""+
                "}";
        Submit(data);

        Intent intent = new Intent(this, MainActivity2.class);

        startActivity(intent);
    }

    private void Submit(String data) {
        String savedata=data;
        String URL="https://mcc-users-api.herokuapp.com/add_new_user";
        requestQueue= Volley.newRequestQueue(getApplicationContext());
        Log.d("TAG", "requestQueue: "+requestQueue);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
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
            public String getBodyContentType(){return "application/json; charset=utf-8";}
            @Override
            public byte[] getBody() throws AuthFailureError {
                try{
                    Log.d("TAG", "savedata: "+savedata);
                    return savedata==null?null:savedata.getBytes("utf-8");
                }catch(UnsupportedEncodingException uee){
                    return null;
                }
            }
        };
        requestQueue.add(stringRequest);
    }




}
