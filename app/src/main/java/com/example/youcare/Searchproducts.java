package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
//import  android.support.*;

import java.util.ArrayList;

public class Searchproducts extends AppCompatActivity implements SearchView.OnQueryTextListener{
    // Here different variables are declared. such as list, adapater, editsearch...

    displayProducts dp;
    boolean regionalUserInput, seasonalUserInput, veganUserInput;
    int environmentUserRating, animalTreatmentUserRating, healthUserRating, fairAndSocialUserRating;
    String UserchosenProduct;


    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] foodNameList;
    ArrayList<FoodNames> arraylist = new ArrayList<FoodNames>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchproducts);

        //Sample products considered for prototype demo.

        foodNameList = new String[]{"Milk", "Milk Powder", "Tomatoes", "Tamarind", "Wine", "Choclate", "Choclate Creame"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < foodNameList.length; i++) {
            FoodNames animalNames = new FoodNames(foodNameList[i]);
            // Binds all strings into an array
            arraylist.add(animalNames);
        }

        // ListViewAdapter is used to pass the strings to the listView, which is realted to the front end work.
        adapter = new ListViewAdapter(Searchproducts.this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }



    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }


    public void setEatingHabits(boolean regionalUserInput, boolean veganUserInput){
//        this.regionalUserInput = regionalUserInput; this.veganUserInput = veganUserInput;
    }
    public void setUserValues(int environmentUserRating, int healthUserRating, int fairAndSocialUserRating, int animalTreatmentUserRating){
//        this.environmentUserRating = environmentUserRating;
//        this.animalTreatmentUserRating = animalTreatmentUserRating;
//        this.healthUserRating = healthUserRating;
//        this.fairAndSocialUserRating = fairAndSocialUserRating;

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // call the activity to show the information of the products.
        //queryDbForProduct();
            UserchosenProduct = query;
            return true;
        }





    public void queryDbForProduct(){
//        DatabaseConnectivity dbconnectiDatabaseConnectivity = new DatabaseConnectivity(this);
//
//            String displayProduct = dbconnectiDatabaseConnectivity.query(regionalUserInput, veganUserInput,environmentUserRating,healthUserRating,fairAndSocialUserRating,animalTreatmentUserRating);
//            dp = new displayProducts(); dp.getdisplayProducts(displayProduct);
//            Intent displayProducts = new Intent(this, displayProducts.class);
//            startActivity(displayProducts);

    }

}
