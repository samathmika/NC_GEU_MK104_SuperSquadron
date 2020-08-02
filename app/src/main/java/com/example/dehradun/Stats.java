package com.example.trafficdetails;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Stats extends AppCompatActivity {
    private String url = "http://192.168.0.109:5000/stats";
    private String postBodyString;
    private MediaType mediaType;
    private RequestBody requestBody;
    private Button connect;
    String traffic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity);
        postRequest("something", url);
    }

    private RequestBody buildRequestBody(String msg) {
        postBodyString = msg;
        mediaType = MediaType.parse("text/plain");
        requestBody = RequestBody.create(String.valueOf(postBodyString), mediaType);
        return requestBody;
    }


    private void postRequest(String message, String URL) {
        RequestBody requestBody = buildRequestBody(message);
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request
                .Builder()
                .post(requestBody)
                .url(URL)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {


                Toast.makeText(Stats.this, "Something went wrong:" + " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                call.cancel();


            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override

            public void onResponse(Call call, final Response response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            traffic = response.body().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // Toast.makeText(Flaskk.this, response.body().string(), Toast.LENGTH_LONG).show();
                    }
                });
                //converting the string to json array object

                //traversing through all the object
            }


        });
    }
}
