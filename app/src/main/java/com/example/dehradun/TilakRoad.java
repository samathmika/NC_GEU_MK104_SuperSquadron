package com.example.dehradun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TilakRoad extends AppCompatActivity {
    Button Shampur, BindalChowk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tilak);
        BindalChowk = (Button) findViewById(R.id.BindalChowk);
        Shampur = (Button) findViewById(R.id.shampur);

        Shampur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(TilakRoad.this, MapsActivity.class);
                intent.putExtra("Sel", "Shampur");
                startActivity(intent);
            }
        });
        BindalChowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(TilakRoad.this, MapsActivity.class);
                intent.putExtra("Sel", "BindalChowk");
                startActivity(intent);
            }
        });
    }
}
