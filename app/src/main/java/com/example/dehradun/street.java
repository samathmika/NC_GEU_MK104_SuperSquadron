package com.example.dehradun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class street extends AppCompatActivity{
    Button Laxmanchowk;
    Button Rajivchowk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street);
        Laxmanchowk = (Button) findViewById(R.id.Laxmanchowk);
        Rajivchowk = (Button) findViewById(R.id.RajivChowk);



        Laxmanchowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(street.this, MapsActivity.class);
                intent.putExtra("Sel","Laxmanchowk");
                startActivity(intent);
            }
    });

        Rajivchowk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(street.this, MapsActivity.class);
                intent.putExtra("Sel","Rajivchowk");
                startActivity(intent);
            }
        });

}
}
