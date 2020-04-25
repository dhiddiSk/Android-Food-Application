package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.youcare.appbody.search.Searchproducts;

public class UserValues extends AppCompatActivity {

    public RatingBar environement, animalTreatment, health, fairAndSocial;
    public android.widget.SeekBar price;
    public Button toshop;
    int environmentUserRating, animalTreatmentUserRating, healthUserRating, fairAndSocialUserRating;


//@parameter userPriceInput refers to the input from the user and @parameter priceOfpurchase to show the price on display
    public int userPriceInput=0;  public TextView priceOfpurchase;
    Searchproducts Obj2 = new Searchproducts();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_values);
        environement = findViewById(R.id.environmentRatingbar);
        animalTreatment = findViewById(R.id.animaltreatmentRating);
        health = findViewById(R.id.HealthId);
        fairAndSocial = findViewById(R.id.FairAndSocial);
        price = (android.widget.SeekBar) findViewById(R.id.PriceSeekbar);
        toshop = findViewById(R.id.shoppingButton);
        priceOfpurchase = findViewById(R.id.priceView);

        //priceOfpurchase.setText(userPriceInput)


        price.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
                userPriceInput = progress;

            }

            @Override
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                String temp = Integer.toString(userPriceInput);
                priceOfpurchase.setText(temp);

            }
       });

        environement.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                environmentUserRating = Math.round(rating);
            }
        });

        health.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                healthUserRating = Math.round(rating);
            }
        });

        fairAndSocial.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                fairAndSocialUserRating = Math.round(rating);
            }
        });

        animalTreatment.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                animalTreatmentUserRating = Math.round(rating);
            }
        });

        toshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent searchbar = new Intent(UserValues.this, ShoppingSearchBar.class);
               // startActivity(searchbar);
                //Searchproducts ApiObj2 = new Searchproducts(environmentUserRating,healthUserRating,fairAndSocialUserRating,animalTreatmentUserRating);
              //  Obj2.setUserValues(environmentUserRating,healthUserRating,fairAndSocialUserRating,animalTreatmentUserRating);
                Intent searchbar = new Intent(UserValues.this, Searchproducts.class);
                startActivity(searchbar);
            }
        });
    }
}