package com.example.dehradun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MKP extends AppCompatActivity {
    Button PrinceChowk,CmiChowk,AragharChowk,Dwarka,CityheartCenter,DoonHospitalChowk,TehsilChowk,MKPChowk;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mkp);
        PrinceChowk = (Button) findViewById(R.id.PrinceChowk);
        CmiChowk = (Button) findViewById(R.id.CmiChowk);
        AragharChowk = (Button) findViewById(R.id.AragharChowk);
        Dwarka = (Button) findViewById(R.id.Dwarka);
        CityheartCenter = (Button) findViewById(R.id.CityheartCenter);
        DoonHospitalChowk = (Button) findViewById(R.id.DoonHospitalChowk);
        TehsilChowk = (Button) findViewById(R.id.TehsilChowk);
        MKPChowk = (Button) findViewById(R.id.MKPChowk);

        PrinceChowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(MKP.this, MapsActivity.class);
                intent.putExtra("Sel", "PrinceChowk");
                startActivity(intent);
            }
        });
        CmiChowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(MKP.this, MapsActivity.class);
                intent.putExtra("Sel", "CmiChowk");
                startActivity(intent);
            }
        });
        AragharChowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(MKP.this, MapsActivity.class);
                intent.putExtra("Sel", "AragharChowk");
                startActivity(intent);
            }
        });
        Dwarka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(MKP.this, MapsActivity.class);
                intent.putExtra("Sel", "Dwarka");
                startActivity(intent);
            }
        });
        CityheartCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(MKP.this, MapsActivity.class);
                intent.putExtra("Sel", "CityheartCenterChowk");
                startActivity(intent);
            }
        });
        DoonHospitalChowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(MKP.this, MapsActivity.class);
                intent.putExtra("Sel", "DoonHospitalChowk");
                startActivity(intent);
            }
        });
        TehsilChowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(MKP.this, MapsActivity.class);
                intent.putExtra("Sel", "TehsilChowk");
                startActivity(intent);
            }
        });
        MKPChowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(MKP.this, MapsActivity.class);
                intent.putExtra("Sel", "MKPChowk");
                startActivity(intent);
            }
        });
    }
}

