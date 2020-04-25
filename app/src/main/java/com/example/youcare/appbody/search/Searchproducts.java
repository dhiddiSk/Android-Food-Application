package com.example.youcare.appbody.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
//import  android.support.*;

import com.example.youcare.FoodNames;
import com.example.youcare.ListViewAdapter;
import com.example.youcare.R;
import com.example.youcare.appbody.preference.FragmentChildActivityOne;
import com.example.youcare.appintro.PreferenceFragment;
import com.example.youcare.database.DatabaseConnectivity;
import com.example.youcare.displayProducts;

import java.util.ArrayList;

import static com.example.youcare.database.DatabaseConnectivity.productstable;

public class Searchproducts extends AppCompatActivity implements SearchView.OnQueryTextListener{

    // Here different variables are declared. such as list, adapater, editsearch...
    displayProducts dp;
    String UserchosenProduct;
    private String TAG = "queryworking";


    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] foodNameList;
    ArrayList<FoodNames> arraylist = new ArrayList<FoodNames>();
    String vegUserInput=null;
    String veganUserInput=null;
    String glutenUserInput=null;
    String lacktoUserInput=null;
    String applyRestrictionsOnUserRecommendations=null;
    int environmentUserRating, fairAndSocialUserRating;

    ArrayList<String> results;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchproducts);

        //Sample products considered for prototype demo.

        foodNameList = new String[]{"milk", "milk powder", "tomatoes", "tamarind", "wine", "choclate", "choclate cream", "banana"};

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



    @Override
    public boolean onQueryTextSubmit(String query) {
        // call the activity to show the information of the products.
            UserchosenProduct = query;
      //  Log.v(TAG,UserchosenProduct);
          queryProduct();
           return false;
        }



    public void userEatingHabits(String vegUserInput, String veganUserInput, String glutenUserInput, String lacktoUserInput, String applyRestrictionsOnUserRecommendations){
        this.vegUserInput = vegUserInput;
        this.veganUserInput = veganUserInput;
        this.glutenUserInput = glutenUserInput;
        this.lacktoUserInput = lacktoUserInput;
        this.applyRestrictionsOnUserRecommendations = applyRestrictionsOnUserRecommendations;
    }

    public void userValues(int environmentUserRating, int fairAndSocialUserRating){
        this.environmentUserRating = environmentUserRating;
        this.fairAndSocialUserRating = fairAndSocialUserRating;

    }

    public void queryProduct(){

        DatabaseConnectivity dbconnect = new DatabaseConnectivity(this);

        String notfound = "Sorry no products found matching your preferences and values";
        Cursor cursor;
        results = new ArrayList<String>();

        try {



     if(applyRestrictionsOnUserRecommendations.equals("yes")) {
         String productSearchQuery = "Select * from '" + productstable + "' where Vegetarian = '" + veganUserInput + "' AND Vegan = '" + veganUserInput + "' AND Glutenfree = '" + glutenUserInput + "' AND Laktofree = '" + lacktoUserInput + "' AND FairSocial = '" + fairAndSocialUserRating + "' AND Enivironment = '"+environmentUserRating+"' AND Product = '"+UserchosenProduct+"'";
       cursor = dbconnect.queryDbForProducts(productSearchQuery);

         if (cursor != null) {
             // move cursor to first row
             if (cursor.moveToFirst()) {
                 do {
                     // Get version from Cursor
                     String producername = cursor.getString(cursor.getColumnIndex("Producers"));

                     // add the bookName into the bookTitles ArrayList
                     results.add(producername);
                     // move to next row
                 } while (cursor.moveToNext());
             }

             cursor.close();
         }
         else {

             results.add(notfound);
         }

     }
     else if(applyRestrictionsOnUserRecommendations.equals("no")){
         String restrictedproductSearchQuery = "Select Producers from '" + productstable + "' where FairSocial = '" + fairAndSocialUserRating + "' AND Enivironment = '"+environmentUserRating+"' AND Product = '"+UserchosenProduct+"'";
         cursor = dbconnect.queryDbForProducts(restrictedproductSearchQuery);
         if (cursor != null) {
             // move cursor to first row
             if (cursor.moveToFirst()) {
                 do {
                     // Get version from Cursor
                     String producername = cursor.getString(cursor.getColumnIndex("Producers"));

                     // add the bookName into the bookTitles ArrayList
                     results.add(producername);
                     // move to next row
                 } while (cursor.moveToNext());
             }

             cursor.close();
         }
         else {

             results.add(notfound);
         }
     }
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            String temp = results.get(1);
            TextView resutltext= findViewById(R.id.resulttextview);
            resutltext.setText(temp);

        }catch (NullPointerException e){

           e.printStackTrace();
    }

    }
}
