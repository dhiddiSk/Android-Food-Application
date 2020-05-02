package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ProductsListAdapter;
import com.example.youcare.appbody.Product;
import com.example.youcare.appbody.Products;
import com.example.youcare.utils.Constants;
import com.example.youcare.utils.LocalStorage;

import java.util.ArrayList;
import java.util.List;

public class DisplayProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProducts;
    private List<Product> productsList;
    private ProductsListAdapter productsListAdapter;
    private TextView tv_noProducts;
    private AppCompatAutoCompleteTextView actv_searchproducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_products);
        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_productsview);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.preffered_products);
        toolbar.setVisibility(View.VISIBLE);

        recyclerViewProducts = findViewById(R.id.recyclerview_products);
        tv_noProducts = findViewById(R.id.tv_no_products);
        actv_searchproducts = findViewById(R.id.et_searchproducts);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewProducts.setLayoutManager(linearLayoutManager);

        productsList = new Products().getInstance().getProducts();
        productsListAdapter = new ProductsListAdapter(this, productsList,tv_noProducts);


        //search products
        // search products

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, getResources().getStringArray(R.array.array_productstypes));

        actv_searchproducts.setThreshold(2);
        actv_searchproducts.setAdapter(adapter);

        recyclerViewProducts.setAdapter(productsListAdapter);
        showUserPreferredProducts(this, productsList);
    }


    private void showUserPreferredProducts(Context context, List<Product> products) {

        String vegetarianPreference = getProductPreference(context, Constants.isVegetarian);
        String veganPreference = getProductPreference(context, Constants.isVegan);
        String glutenPreference = getProductPreference(context, Constants.isgluten);
        String laktoPreference = getProductPreference(context, Constants.isLakto);
        String noRestrictionPrefernce = getProductPreference(context, Constants.noRestriction);

        int environmentPreference = getRatingPreference(context, Constants.environmentrating);
        int fairsocialPreference = getRatingPreference(context, Constants.fairsocialrating);

        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : products) {
            // if applynorestrictions is NO, doing environment and fairsocial validation
            if (noRestrictionPrefernce.equals("no")) {
                if (environmentPreference == product.getEnvironment()) {
                    if (fairsocialPreference == product.getFairSocialPrice()) {
                        filteredProducts.add(product);
                    }
                }
            }
            // applynorestrictions is YES, validating all preferences
            else {
                if (vegetarianPreference.matches(product.getVegetarian())
                        && veganPreference.matches(product.getVegan())
                        && glutenPreference.matches(product.getGlutenfree())
                        && laktoPreference.matches(product.getLaktofree())
                        && environmentPreference == product.getEnvironment()
                        && fairsocialPreference == product.getFairSocialPrice()) {
                       filteredProducts.add(product);
                }
            }
    }
        System.out.println("current products list count > "+products.size());
        productsListAdapter.filterProducts(filteredProducts); // 1st filter wit preferences

        actv_searchproducts.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((filteredProducts.size() > 0 ) && (s.length() > 1 || actv_searchproducts.getText().toString().length() > 1)) {
                    filterProducts(actv_searchproducts.getText().toString(), filteredProducts);
                }else{
                    productsListAdapter.filterProducts(filteredProducts); // showing filtered list
                }
            }
        });

}

    private void filterProducts(String searchWord, List<Product> filteredProducts) {
        List<Product> filteredBySearchProducts = new ArrayList<>(); //2nd filter by keyword
        for (Product product : filteredProducts){
            if (product.getProductName().toLowerCase().matches(searchWord.toLowerCase())){
                filteredBySearchProducts.add(product);
            }
        }
        System.out.println("current products list count > "+productsList.size());
        productsListAdapter.filterProducts(filteredBySearchProducts);
        if (productsList.size() > 0 || filteredProducts.size() > 0){
          //  hideKeyBoard(this);
        }

    }

    /***
     * Hiding Keyboard after getting Products
     * @param activity
     */
    private void hideKeyBoard(Activity activity) {
        View view1 = activity.getCurrentFocus();
        if(view1 != null){
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view1.getApplicationWindowToken(), 0);
        }
    }

    private int getRatingPreference(Context context, String ratingPreference) {
        return LocalStorage.getLocallyStoredRating(context, ratingPreference);
    }

    public String getProductPreference(Context context, String productId) {
        return LocalStorage.getLocallyStoredValue(context, productId);
    }

}
