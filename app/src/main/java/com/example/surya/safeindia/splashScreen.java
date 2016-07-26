package com.example.surya.safeindia;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {

    public static int SPLASH_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splashScreen.this,HomeTab.class);
                splashScreen.this.startActivity(intent);
                splashScreen.this.finish();
            }
        },SPLASH_TIME_OUT);
    }
}
