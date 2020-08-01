package com.example.dehradun;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class splashActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

// decide here whether to navigate to Login or Main Activity

        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if (pref.getBoolean("activity_executed", false)) {
            Intent intent = new Intent(this, Mainpage.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
