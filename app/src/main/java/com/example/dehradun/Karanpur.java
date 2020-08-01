package com.example.dehradun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Karanpur extends AppCompatActivity {
    Button Survey,OldSurvey,DBS,DAV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karanpur);
        Survey = (Button) findViewById(R.id.Survey);
        OldSurvey = (Button) findViewById(R.id.OldSurvey);
        DBS = (Button) findViewById(R.id.DBS);
        DAV = (Button) findViewById(R.id.DAV);
        Survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Karanpur.this, MapsActivity.class);
                intent.putExtra("Sel", "Survey");
                startActivity(intent);
            }
        });
        OldSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Karanpur.this, MapsActivity.class);
                intent.putExtra("Sel", "Dilaram");
                startActivity(intent);
            }
        });
        DBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Karanpur.this, MapsActivity.class);
                intent.putExtra("Sel", "DBS");
                startActivity(intent);
            }
        });
        DAV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Karanpur.this, MapsActivity.class);
                intent.putExtra("Sel", "DAV");
                startActivity(intent);
            }
        });
    }
}
