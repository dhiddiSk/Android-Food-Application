package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    protected int LaunchScreenTime = 2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent loginScreen = new Intent(this, LoginScreenActivity.class);
//        startActivity(loginScreen);


//        Intent homeIntent = new Intent(this, LoginScreenActivity.class);
//        startActivity(homeIntent);

        /*
        Here a new handler is started, which is useful to display the launch screen for certain period of time.
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ApplicationIntroIntent = new Intent(MainActivity.this, AppInfo.class);
                startActivity(ApplicationIntroIntent);
//            @method finish() is used to exit the applicaiton when back button is pressed after the launch screen is done, which means the launch screen is fired when the application is
                //newly opened
              finish();
            }
        }, LaunchScreenTime);


    }
}
