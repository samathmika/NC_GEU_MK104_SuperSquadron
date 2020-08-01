package com.example.dehradun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Jhanda extends AppCompatActivity {
    Button Saharanpur,Shampur,Lakhibagh,Pipalmilndi,Bhandari,Hanumanchowk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jhandamohalla);
        Saharanpur = (Button) findViewById(R.id.saharanpur);
        Shampur= (Button) findViewById(R.id.shampur);
        Lakhibagh= (Button) findViewById(R.id.lakhibagh);
        Pipalmilndi= (Button) findViewById(R.id.pipalmilndi);
        Bhandari= (Button) findViewById(R.id.bhandari);
        Hanumanchowk= (Button) findViewById(R.id.hanumanchowk);

        Saharanpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Jhanda.this, MapsActivity.class);
                intent.putExtra("Sel","Saharanpur");
                startActivity(intent);
            }
        });

        Shampur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Jhanda.this, MapsActivity.class);
                intent.putExtra("Sel","Shampur");
                startActivity(intent);
            }
        });
        Pipalmilndi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Jhanda.this, MapsActivity.class);
                intent.putExtra("Sel","Pipalmilndi");
                startActivity(intent);
            }
        });
        Lakhibagh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Jhanda.this, MapsActivity.class);
                intent.putExtra("Sel","Lakhibagh");
                startActivity(intent);
            }
        });
        Bhandari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Jhanda.this, MapsActivity.class);
                intent.putExtra("Sel","Bhandari");
                startActivity(intent);
            }
        });
        Hanumanchowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Jhanda.this, MapsActivity.class);
                intent.putExtra("Sel","Hanumanchowk");
                startActivity(intent);
            }
        });


    }
}
