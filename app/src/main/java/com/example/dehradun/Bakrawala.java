package com.example.dehradun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class Bakrawala<Signals> extends AppCompatActivity {
    Button Kwality, Kanak, Survey, NanysBakery, Bhel, Globe, Nishvila;
    TextView signals;
    private Context context;

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakrawala);
        Kwality = (Button) findViewById(R.id.Kwality);
        Kanak = (Button) findViewById(R.id.Kanak);
        Survey = (Button) findViewById(R.id.Survey);
        NanysBakery = (Button) findViewById(R.id.NanysBakery);
        Bhel = (Button) findViewById(R.id.Bhel);
        Globe = (Button) findViewById(R.id.Globe);
        Nishvila = (Button) findViewById(R.id.Nishvila);
        signals = (TextView) findViewById(R.id.textView9);

        Kanak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Bakrawala.this, MapsActivity.class);
                intent.putExtra("Sel", "Kanak");
                startActivity(intent);
            }
        });
        Kwality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Bakrawala.this, MapsActivity.class);
                intent.putExtra("Sel", "Kwality");
                startActivity(intent);
            }
        });
        Survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Bakrawala.this, MapsActivity.class);
                intent.putExtra("Sel", "Survey");
                startActivity(intent);
            }
        });
        NanysBakery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Bakrawala.this, MapsActivity.class);
                intent.putExtra("Sel", "NanysBakery");
                startActivity(intent);
            }
        });
        Bhel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Bakrawala.this, MapsActivity.class);
                intent.putExtra("Sel", "Bhel");
                startActivity(intent);
            }
        });
        Globe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Bakrawala.this, MapsActivity.class);
                intent.putExtra("Sel", "Globe");
                startActivity(intent);
            }
        });
        Nishvila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(Bakrawala.this, MapsActivity.class);
                intent.putExtra("Sel", "NishvilaChowk");
                startActivity(intent);
            }
        });
         final boolean[] Signals=new boolean[]{false, true, false, false, true, true, false, true, false, true, true};

        final int[] i = {0};

        new CountDownTimer(55000, 5000) {

            public void onTick(long millisUntilFinished) {
                if (Signals[i[0]]) {
                    TextView txt = (TextView) findViewById(R.id.textView9);
                    setTextViewDrawableColor(txt, R.color.my_color);
                } else {
                    TextView txt = (TextView) findViewById(R.id.textView9);
                    setTextViewDrawableColor(txt, R.color.red);
                }
                i[0]++;
            }
            public void onFinish() {
                      i[0]=0;
                      onTick(5000);
            }
        }.start();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setTextViewDrawableColor(TextView textView, int color) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getColor(color), PorterDuff.Mode.SRC_IN));
            }
        }
    }

}

