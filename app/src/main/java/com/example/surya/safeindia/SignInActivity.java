package com.example.surya.safeindia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import io.fabric.sdk.android.Fabric;

public class SignInActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "2cmsXIUANsuC3B8aS0VJp6dUY";
    private static final String TWITTER_SECRET = "SX6YmIqxULTARRY5WihaBQnJ76QnlDmXGGCOC8gNw0LPvndVbQ";
    private static final String MYPREFERENCES="FirstSigninPref";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public static boolean Activityaccess=false;
    DigitsAuthButton digitsAuthButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences=getApplicationContext().getSharedPreferences(MYPREFERENCES,MODE_PRIVATE);
         editor=preferences.edit();
        editor.putBoolean("FirstSignIN",true);
        editor.commit();

        if(preferences.getBoolean("FirstSignIN",true))
        {
            Intent intent=new Intent(this,MapsActivity.class);
            this.startActivity(intent);
        }

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits());
        setContentView(R.layout.activity_sign_in);

         digitsAuthButton=(DigitsAuthButton) findViewById(R.id.authButton);
        digitsAuthButton.setCallback(((Authenticate)getApplication()).getAuthCallback());



        if(Activityaccess){
            Intent intent=new Intent(SignInActivity.this,MapsActivity.class);
            SignInActivity.this.startActivity(intent);
            SignInActivity.this.finish();
        }

     //   AuthCallback authCallback=((Authenticate) getApplication()).getAuthCallback();


//        Intent intent=new Intent(SignInActivity.this,MapActivity.class);
//        SignInActivity.this.startActivity(intent);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent intent=new Intent(this,MapsActivity.class);
        this.startActivity(intent);
        editor.putBoolean("FirstSignIN",false);
        editor.commit();
    }
}
