package com.example.surya.safeindia;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthConfig;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;

/**
 * Created by surya on 13/7/16.
 */
public class Authenticate extends Application {


    private AuthCallback authCallback;
    private static final String TWITTER_KEY = "2cmsXIUANsuC3B8aS0VJp6dUY";
    private static final String TWITTER_SECRET = "SX6YmIqxULTARRY5WihaBQnJ76QnlDmXGGCOC8gNw0LPvndVbQ";
    public static String phone;
    @Override
    public void onCreate() {
        super.onCreate();
        final TwitterAuthConfig authConfig=new TwitterAuthConfig(TWITTER_KEY,TWITTER_SECRET);
        Fabric.with(this,new TwitterCore(authConfig),new Digits());
        final DigitsAuthConfig digitsAuthConfig;

        authCallback=new AuthCallback() {

            @Override
            public void success(DigitsSession session, String phoneNumber) {
              //   digitsAuthConfig=new DigitsAuthConfig(false,phoneNumber,null,null,null,null);
                String number=phoneNumber;
                Log.d("Authenticate:::",phoneNumber.toString());

                if(session.isLoggedOutUser());
                    Log.d("Real user",phoneNumber.toString());

                if(session.isValidUser())
                    Log.d("Is Valid User",phoneNumber.toString());

                

              //  Digits.authenticate(digitsAuthConfig);
                // Intent intent=new Intent(Authenticate.this,MapActivity.class);
//                   Authenticate.this.startActivity(intent);
                //Digits.authenticate(authCallback,phoneNumber);
                    phone=phoneNumber;
                Toast.makeText(getApplicationContext(),"Number is: "+phoneNumber,Toast.LENGTH_LONG).show();
               // Digits.authenticate(digitsAuthConfig);
               // Intent intent=new Intent(authConfig.this)
            }

            @Override
            public void failure(DigitsException error) {
                Log.d("Error occured",error.toString());
            }
        };
    }

    public AuthCallback getAuthCallback() {
        Log.d("getAuthCallback","In Auth call back method");
        return authCallback;
    }
}
