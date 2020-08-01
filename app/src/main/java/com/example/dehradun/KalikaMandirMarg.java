package com.example.dehradun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class KalikaMandirMarg extends AppCompatActivity {
    Button Mottibazaar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mottibazaar);
        Mottibazaar = (Button) findViewById(R.id.Mottibazaar);

        Mottibazaar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(KalikaMandirMarg.this, MapsActivity.class);
                intent.putExtra("Sel", "MottibazaarChowk");
                startActivity(intent);
            }
        });
    }
}
