package com.example.youcare.appbody.search;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
//import  android.support.*;

import com.example.youcare.FoodNames;
import com.example.youcare.ListViewAdapter;
import com.example.youcare.R;
import com.example.youcare.database.DatabaseConnectivity;
import com.example.youcare.DisplayProductsActivity;

import java.util.ArrayList;

import static com.example.youcare.database.DatabaseConnectivity.productstable;

public class Searchproducts extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Here different variables are declared. such as list, adapater, editsearch...
    private DisplayProductsActivity dp;
    private String userEnteredProduct;
    private String TAG = "queryworking";


    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] foodNameList;
    ArrayList<FoodNames> arraylist = new ArrayList<FoodNames>();
    String vegUserInput = null;
    String veganUserInput = null;
    String glutenUserInput = null;
    String lacktoUserInput = null;
    String applyRestrictionsOnUserRecommendations = null;
    int environmentUserRating, fairAndSocialUserRating;

    ArrayList<String> results = new ArrayList<String>();
    private boolean onlineShopper;
    private boolean superMarketShopper;


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

        try {
            productName = results.get(0);

            if (productName != null) {
                TextView resutltext = findViewById(R.id.resulttextview);
                resutltext.setText(productName);
            }

        } catch (NullPointerException e) {

            e.printStackTrace();
        }
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
        userEnteredProduct = query;
        //  Log.v(TAG,userEnteredProduct);
        if (userEnteredProduct != null && !userEnteredProduct.trim().isEmpty()) {
            queryProduct(userEnteredProduct);
        } else {
            Toast.makeText(getApplicationContext(), "Please enter your product", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    public void userEatingHabits(String vegUserInput, String veganUserInput, String glutenUserInput, String lacktoUserInput, String applyRestrictionsOnUserRecommendations) {
        this.vegUserInput = vegUserInput;
        this.veganUserInput = veganUserInput;
        this.glutenUserInput = glutenUserInput;
        this.lacktoUserInput = lacktoUserInput;
        this.applyRestrictionsOnUserRecommendations = applyRestrictionsOnUserRecommendations;
    }

    public void userShoppingValues(boolean superMarketShopper, boolean onlineShopping) {
        this.superMarketShopper = superMarketShopper;
        this.onlineShopper = onlineShopping;
    }

    public void userValues(int environmentUserRating, int fairAndSocialUserRating) {
        this.environmentUserRating = environmentUserRating;
        this.fairAndSocialUserRating = fairAndSocialUserRating;

    }

    public void queryProduct(String userEnteredProduct) {

        DatabaseConnectivity dbconnect = new DatabaseConnectivity(this);

        String notfound = "Sorry no products found matching your preferences and values";
        Cursor cursor;


        try {

            Log.v(TAG,"User prefernce selection > "+applyRestrictionsOnUserRecommendations);
            // If user has selected veg or vegan xyz rather than no restrictions
            if ((applyRestrictionsOnUserRecommendations != null) && (applyRestrictionsOnUserRecommendations.equalsIgnoreCase("yes"))) {
                String productSearchQuery = "Select * from '" + productstable + "' where Vegetarian = '" + vegUserInput + "' AND Vegan = '" + veganUserInput + "' AND Glutenfree = '" + glutenUserInput + "' AND Laktofree = '" + lacktoUserInput + "' AND FairSocial = '" + fairAndSocialUserRating + "' AND Enivironment = '" + environmentUserRating + "' AND Product = '" + userEnteredProduct + "'";
                cursor = dbconnect.queryDbForProducts(productSearchQuery);

                if (cursor != null) {
                    // move cursor to first row
                    if (cursor.moveToFirst()) {
                        do {
                            int temp = 0;
                            // Get version from Cursor
                            String producername = cursor.getString(cursor.getColumnIndex("Producers"));

                            // add the productManufacturerName into the results List
                            results.add(temp, producername);
                            // move to next row
                            temp = temp + 1;
                        } while (cursor.moveToNext());
                    }

                    cursor.close();
                } else {
                    results.add(notfound);
                }
            }
            // if user has selected NO RESTRICTIONS
            else if ((applyRestrictionsOnUserRecommendations != null) && (applyRestrictionsOnUserRecommendations.equals("no"))) {
                String restrictedproductSearchQuery = "Select * from '" + productstable + "' where FairSocial = '" + fairAndSocialUserRating + "' AND Enivironment = '" + environmentUserRating + "' AND Product = '" + this.userEnteredProduct + "'";
                cursor = dbconnect.queryDbForProducts(restrictedproductSearchQuery);
                if (cursor != null) {
                    // move cursor to first row
                    if (cursor.moveToFirst()) {
                        do {
                            int temp = 0;
                            // Get version from Cursor
                            String producername = cursor.getString(cursor.getColumnIndex("Producers"));

                            // add the bookName into the bookTitles ArrayList
                            results.add(temp, producername);
                            // move to next row
                            temp = temp + 1;
                        } while (cursor.moveToNext());
                    }

                    cursor.close();
                } else {

                    results.add(notfound);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    String productName = null;

    @Override
    protected void onResume() {
        super.onResume();
    }


}
