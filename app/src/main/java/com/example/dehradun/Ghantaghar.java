package com.example.dehradun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Ghantaghar extends AppCompatActivity {
    Button Clocktower, TehsilChowk, DoonHospital, BudhaPark, Darshanlal, Cityheartcenter, Kanak, Kwality, Lansdowne;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghantaghar);
        Clocktower = (Button) findViewById(R.id.Clocktower);
        TehsilChowk = (Button) findViewById(R.id.TehsilChowk);
        DoonHospital = (Button) findViewById(R.id.DoonHospital);
        BudhaPark = (Button) findViewById(R.id.BudhaPark);
        Darshanlal = (Button) findViewById(R.id.Darshanlal);
        Cityheartcenter = (Button) findViewById(R.id.Cityheartcenter);
        Kanak = (Button) findViewById(R.id.Kanak);
        Kwality = (Button) findViewById(R.id.Kwality);
        Lansdowne = (Button) findViewById(R.id.Lansdowne);

        Clocktower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Ghantaghar.this, MapsActivity.class);
                intent.putExtra("Sel", "Clocktower");
                startActivity(intent);
            }
        });
        TehsilChowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Ghantaghar.this, MapsActivity.class);
                intent.putExtra("Sel", "TehsilChowk");
                startActivity(intent);
            }
        });
        DoonHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Ghantaghar.this, MapsActivity.class);
                intent.putExtra("Sel", "DoonHospitalChowk");
                startActivity(intent);
            }
        });
        BudhaPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Ghantaghar.this, MapsActivity.class);
                intent.putExtra("Sel", "BudhaPark");
                startActivity(intent);
            }
        });
        Darshanlal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Ghantaghar.this, MapsActivity.class);
                intent.putExtra("Sel", "DarshanlalChowk");
                startActivity(intent);
            }
        });
        Cityheartcenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ghantaghar.this, MapsActivity.class);
                intent.putExtra("Sel", "CityheartcenterChowk");
                startActivity(intent);
            }
        });
        Kanak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Ghantaghar.this, MapsActivity.class);
                intent.putExtra("Sel", "Kanak");
                startActivity(intent);
            }
        });
        Kwality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Ghantaghar.this, MapsActivity.class);
                intent.putExtra("Sel", "Kwality");
                startActivity(intent);
            }
        });
        Lansdowne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Ghantaghar.this, MapsActivity.class);
                intent.putExtra("Sel", "Lansdowne");
                startActivity(intent);
            }
        });

    }
}
