package com.example.dehradun;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Mainpage extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private static final String Tag = "Swipe position";
    private float x1, x2;
    private static int MIN_DIST = 150;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        this.gestureDetector = new GestureDetector(Mainpage.this, this);
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder =new AlertDialog.Builder(Mainpage.this);
        builder.setMessage("Are You sure you want to exit?");
        builder.setCancelable(true);
        builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog  alertDialog =builder.create();
        alertDialog.show();
    }

    @Override
        public boolean onTouchEvent (MotionEvent event){
            gestureDetector.onTouchEvent(event);
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x1 = event.getX();
                    break;
                case MotionEvent.ACTION_UP:
                    x2 = event.getX();
                    float valueX = x2 - x1;
                    if (Math.abs(valueX) > MIN_DIST) {
                        if (x2 > x1) {
                            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                            Log.d(Tag, "onTouchEvent: Check traffic ");
                            Intent intent = new Intent(Mainpage.this, Feedback.class);
                            startActivity(intent);
                        } else {

                            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                            Log.d(Tag, "onTouchEvent: Check Traffic");
                            Intent intent = new Intent(Mainpage.this, AreaActivity.class);
                            startActivity(intent);
                        }
                    }

            }
            return super.onTouchEvent(event);
        }

        @Override
        public boolean onDown (MotionEvent motionEvent){
            return false;
        }

        @Override
        public void onShowPress (MotionEvent motionEvent){

        }

        @Override
        public boolean onSingleTapUp (MotionEvent motionEvent){
            return false;
        }

        @Override
        public boolean onScroll (MotionEvent motionEvent, MotionEvent motionEvent1,float v, float v1)
        {
            return false;
        }

        @Override
        public void onLongPress (MotionEvent motionEvent){

        }

        @Override
        public boolean onFling (MotionEvent motionEvent, MotionEvent motionEvent1,float v, float v1)
        {
            return false;
        }


    }
