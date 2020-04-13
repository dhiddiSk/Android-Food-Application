package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

/*
This class refers to the eating habits of the user like vegan and vegetarian.
 */


public class EatingPreferences extends AppCompatActivity {


    Switch regionalOne, regionalTwo, seasonalOne, seasonalTwo, veganOne, veganTwo, veganThree, vegOne, vegTwo, vegThree;
    Button applyFilters;


   // @param  tempButtonCounter refers to count the user operations on the switches and used to notify the user if none is selected
    int tempButtonCounter =0;


    boolean regionalUserInput, seasonalUserInput;
    boolean veganUserInput;
    boolean vegUserInput;

    DatabaseConnectivity database;

    searchproducts searchObj = new searchproducts();
    DataBaseInsertingValues insertingValues = new DataBaseInsertingValues();

    String milktable = "milk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_preferences);
        regionalOne = findViewById(R.id.RegionalSwitch1);
       // regionalTwo = findViewById(R.id.RegionalSwitch2);
        regionalTwo = findViewById(R.id.RegionalSwitch3);
        seasonalOne = findViewById(R.id.seasonalSwitch1);
       // sesonalTwo = findViewById(R.id.seasonalSwitch2);
        seasonalTwo = findViewById(R.id.seasonalswitch3);
        veganOne = findViewById(R.id.veganSwitch1);
        veganTwo = findViewById(R.id.veganSwitch2);
        veganThree = findViewById(R.id.veganSwitch3);
        vegOne = findViewById(R.id.vegetarianSwitch1);
        vegTwo = findViewById(R.id.vegetarianSwitch2);
        vegThree = findViewById(R.id.vegetarianSwitch3);
        applyFilters = findViewById(R.id.applyFilters);

        database=new DatabaseConnectivity(this);

        //** Using this between just to insert the products data, just I was testing it//
        boolean notifyInsertion = insertingValues.insertingData(database);
         if(!notifyInsertion){
             Toast.makeText(EatingPreferences.this, "insertion failed", Toast.LENGTH_SHORT).show();

         }
         else {
             Toast.makeText(EatingPreferences.this, "insertion succeed", Toast.LENGTH_SHORT).show();

         }

        //***************************************************************//


        veganOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    tempButtonCounter++;
                    //Now disable the first button of the nonVeg, i.e nonVeg = true;
                    veganTwo.setChecked(false);
                    veganThree.setChecked(false);
                    vegOne.setEnabled(false);
                    vegThree.setEnabled(false);

                    veganUserInput = true;

                }
                if (!isChecked) {
                    // this is something which is vice versa to the above if condition
                    vegOne.setEnabled(true);
                    vegThree.setEnabled(true);
                }
            }
        });

        veganTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    tempButtonCounter++;
                    //Now disable the first button of the nonVeg, i.e nonVeg = true;
                    veganOne.setChecked(false);
                    veganThree.setChecked(false);

                    veganUserInput = true;


                }
            }
        });

        veganThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    tempButtonCounter++;
                    //Now disable the first button of the nonVeg, i.e nonVeg = true;
                    veganOne.setChecked(false);
                    veganTwo.setChecked(false);

                    veganUserInput = false;
                }
//                if(!isChecked){
//                    // this is something which is vice versa to the above if condition
//                    nonvegOne.setEnabled(true);
//                }
            }
        });


        vegOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    tempButtonCounter++;
                    //Now disable the nonVeg button
                    veganOne.setEnabled(false);
                    vegTwo.setChecked(false);
                    vegThree.setChecked(false);
                }

                if (!isChecked) {
                    veganOne.setEnabled(true);
                }


//                else {
//                    // The toggle is disabled
//                     veganOne.setEnabled(true);
//                    //Do not disable the nonveg button
//                }
            }
        });

        vegTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Since the user is non vegetarian then, user has an option of choosing and not choosing the veg and vegan food.
                    vegOne.setChecked(false);
                    vegThree.setChecked(false);
                }
            }
        });

        vegThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Since the user is non vegetarian then, user has an option of choosing and not choosing the veg and vegan food.
                    tempButtonCounter++;
                    vegOne.setChecked(false);
                    vegTwo.setChecked(false);
                }
            }
        });

        regionalOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Since the user is non vegetarian then, user has an option of choosing and not choosing the veg and vegan food.
                    tempButtonCounter++;
                    regionalTwo.setChecked(false);
                    //regionalTwo.setChecked(false);

                    regionalUserInput = true;
                }
            }
        });


        regionalTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Since the user is non vegetarian then, user has an option of choosing and not choosing the veg and vegan food.
                    tempButtonCounter++;
                   // regionalTwo.setChecked(false);
                    regionalOne.setChecked(false);

                    regionalUserInput = false;
                }
            }
        });

        seasonalOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Since the user is non vegetarian then, user has an option of choosing and not choosing the veg and vegan food.
                    tempButtonCounter++;
                   // sesonalTwo.setChecked(false);
                    seasonalTwo.setChecked(false);
                    seasonalUserInput = true;
                }
            }
        });

        seasonalTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Since the user is non vegetarian then, user has an option of choosing and not choosing the veg and vegan food.
                    tempButtonCounter++;
                    seasonalOne.setChecked(false);
                    seasonalUserInput = false;
                   // sesonalTwo.setChecked(false);
                }
            }
        });

        applyFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EatingPreferences.this, UserValues.class);

                if(tempButtonCounter++ == 0){

                    Toast.makeText(EatingPreferences.this, "Please match your preferences!", Toast.LENGTH_SHORT).show();
                }
                else{
                    //new searchproducts(regionalUserInput,seasonalUserInput, veganUserInput);
                    searchObj.setEatingHabits(regionalUserInput, veganUserInput);
                    startActivity(intent);
                }

            }


        });
    }
}