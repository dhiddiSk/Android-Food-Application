package com.example.youcare.appbody.preference;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.example.youcare.R;
import com.example.youcare.appbody.search.Searchproducts;

public class FragmentChildActivityTwo extends AppCompatActivity {

    private RatingBar environement, fairAndSocial;
    private Button Save, envdetail, fsdetail;
    private int environmentUserRating=0, fairAndSocialUserRating=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_child_two);
        environement = (RatingBar) findViewById(R.id.environmentRatingbar);
        fairAndSocial = findViewById(R.id.FairSocialRatingbar);
        envdetail = findViewById(R.id.EnvironementDetailedDescription);
        fsdetail = findViewById(R.id.FairAndSocialDetailedDescription);
        Save = findViewById(R.id.SaveButton);


        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Searchproducts objsearachproducts = new Searchproducts();
                objsearachproducts.userValues(environmentUserRating,fairAndSocialUserRating);


                Intent i = new Intent(FragmentChildActivityTwo.this, Searchproducts.class);
                startActivity(i);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

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
    }
}

