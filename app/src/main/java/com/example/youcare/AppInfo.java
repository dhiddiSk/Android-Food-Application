//package com.example.youcare;
//
//import androidx.core.content.ContextCompat;
//import androidx.fragment.app.Fragment;
//
//import android.content.Intent;
//import android.os.Bundle;
////import androidx.
//
////import com.github.paolorotolo.appintro;
//import com.github.paolorotolo.appintro.AppIntro;
//import com.github.paolorotolo.appintro.AppIntroFragment;
//
//public class AppInfo extends AppIntro {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        /*
//        So here use the AppIntro to add the slides using different xml activities which can be used for sliding the window, which are automatically generated from teh
//        AppIntro2 package.
//         */
//        addSlide(AppIntroFragment.newInstance("Sustainability", "This is my first info page", R.drawable.sustainability, ContextCompat.getColor(getApplicationContext(), R.color.colorAccent)));
//        addSlide(AppIntroFragment.newInstance("Social Foot print", "This is my Second info page", R.drawable.socialfootprint, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary)));
//        addSlide(AppIntroFragment.newInstance("CO2 Foot print", "This is my third info page", R.drawable.co2footprint, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark)));
//
//    }
//
//    @Override
//    public void onDonePressed(Fragment currentFragement){
//        super.onDonePressed(currentFragement);
//        // @loginScreen intent is created to call the login activtiy page after the done button is pressed
//        Intent loginScreen = new Intent(this, UserLogin.class);
//        startActivity(loginScreen);
//        finish();
//    }
//
//    @Override
//    public void onSkipPressed(Fragment currentFragment){
//        super.onSkipPressed(currentFragment);
//        // here if the user wants to skip the introduction page activity then he can skip it and then enter into the login page activity
//        Intent loginScreen = new Intent(this, UserLogin.class);
//        startActivity(loginScreen);
//        finish();
//    }
//
//}