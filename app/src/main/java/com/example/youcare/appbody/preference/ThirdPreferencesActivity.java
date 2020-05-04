package com.example.youcare.appbody.preference;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.example.youcare.DisplayProductsActivity;
import com.example.youcare.R;
import com.example.youcare.appbody.MainActivity;
import com.example.youcare.authentication.LoginActivity;
import com.example.youcare.utils.LocalStorage;

public class ThirdPreferencesActivity extends AppCompatActivity{

    private RatingBar environement, fairAndSocial;
    private Button envdetail, fsdetail;
    LinearLayout button_save;
    private int environmentUserRating = 0, fairAndSocialUserRating = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_child_two);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_envfair);
        setSupportActionBar(toolbar);

        environement = findViewById(R.id.environmentRatingbar);
        fairAndSocial = findViewById(R.id.FairSocialRatingbar);
        envdetail = findViewById(R.id.EnvironementDetailedDescription);
        envdetail.setPaintFlags(envdetail.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        fsdetail = findViewById(R.id.FairAndSocialDetailedDescription);
        fsdetail.setPaintFlags(fsdetail.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        button_save = findViewById(R.id.SaveButton);
        envdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ThirdPreferencesActivity.this, DetailedDescriptionEnvironemt.class);
                startActivity(i);

            }
        });

        environement.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                environmentUserRating = Math.round(rating);
            }
        });

        fairAndSocial.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                fairAndSocialUserRating = Math.round(rating);
            }
        });


        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = LocalStorage.getLocallyStoredValue(v.getContext(),"email");
                LocalStorage.storeUserRatings(v.getContext(),userId,environmentUserRating,fairAndSocialUserRating);

                Intent intent = new Intent(ThirdPreferencesActivity.this, DisplayProductsActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}

