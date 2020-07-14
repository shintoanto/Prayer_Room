package com.emmj.prayerroom;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        // splashscreen code
        new Handler().postDelayed(new Runnable() {

                                      @Override
                                      public void run() {

                                          // This method will be executed once the timer is over
                                          //Checking internet connection.
                                          ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                                          assert manager != null;
                                          NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
                                          boolean isConnected = activeNetwork != null && activeNetwork.isConnected();

                                          if (isConnected) {
                                              Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                              startActivity(main);
                                              finish();

                                          } else {

                                              //Showing No Internet Message
                                              final Dialog dialog = new Dialog(SplashScreenActivity.this, android.R.style.Theme_NoTitleBar_Fullscreen);
                                              dialog.setContentView(R.layout.internetdialoguebox);
                                              dialog.show();
                                          }

                                      }
                                  },
                //Splash screen delay time.
                3000);
    }
}

