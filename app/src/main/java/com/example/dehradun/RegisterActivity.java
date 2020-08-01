package com.example.dehradun;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Patterns;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.StringWriter;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, password;
    Button register;
    String URL = "http:// 192.168.43.4/Volley/Registration.php";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register);
        progressDialog = new ProgressDialog(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registeruser();
                Intent intent = new Intent(RegisterActivity.this, Mainpage.class);
                startActivity(intent);
            }
        });
    }

    private void registeruser() {
        final String Name, Email, Password;
        Name = name.getText().toString();
        Email = email.getText().toString();
        Password = password.getText().toString();
        if (TextUtils.isEmpty(Name) && TextUtils.isEmpty(Email) && TextUtils.isEmpty(Password)) {
            name.setError("Please Enter Name...");
            password.setError("Please Enter Password...");
            email.setError("Please Enter Email....");
        } else if (TextUtils.isEmpty(Name)) {
            name.setError("Please Enter Name...");
        } else if (TextUtils.isEmpty(Email)) {
            email.setError("Please Enter Email....");
        } else {
            password.setError("Please Enter Password...");
        }

        progressDialog.setTitle("Register account");
        progressDialog.setMessage("Please wait");
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();
        StringRequest registerData = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String result = jsonObject.getString("success");
                    if (result.equals("2")) {
                        Toast.makeText(RegisterActivity.this, "Account Already Exist,Please use another mail", Toast.LENGTH_SHORT).show();
                    } else if (result.equals("3")) {
                        Toast.makeText(RegisterActivity.this, "Account not created Successfully", Toast.LENGTH_SHORT).show();
                    } else if (result.equals("1")) {
                        Toast.makeText(RegisterActivity.this, "Account created successfully", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(RegisterActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("name", Name);
                data.put("eamil", Email);
                data.put("password", Password);
                return data;
            }
        };
        Volley.newRequestQueue(this).add(registerData);
    }
}