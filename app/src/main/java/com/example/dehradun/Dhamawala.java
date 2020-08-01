package com.example.dehradun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Dhamawala extends AppCompatActivity {
    Button RailwayStationChowk,PrinceChowk,TehsilChowk,MotibazaarChowk,Pipalmilndi;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhamawala);
        RailwayStationChowk = (Button) findViewById(R.id.RailwayStationChowk);
        PrinceChowk = (Button) findViewById(R.id.PrinceChowk);
        TehsilChowk = (Button) findViewById(R.id.DehsilChowk);
        MotibazaarChowk = (Button) findViewById(R.id.MotibazaarChowk);
        Pipalmilndi = (Button) findViewById(R.id.PipalMandiChowk);

        RailwayStationChowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Dhamawala.this, MapsActivity.class);
                intent.putExtra("Sel", "RailwayStationChowk");
                startActivity(intent);
            }
        });
        PrinceChowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Dhamawala.this, MapsActivity.class);
                intent.putExtra("Sel", "PrinceChowk");
                startActivity(intent);
            }
        });
        TehsilChowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Dhamawala.this, MapsActivity.class);
                intent.putExtra("Sel", "TehsilChowk");
                startActivity(intent);
            }
        });
        MotibazaarChowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Dhamawala.this, MapsActivity.class);
                intent.putExtra("Sel", "MottibazaarChowk");
                startActivity(intent);
            }
        });
        Pipalmilndi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Dhamawala.this, MapsActivity.class);
                intent.putExtra("Sel", "Pipalmilndi");
                startActivity(intent);
            }
        });

    }
}
