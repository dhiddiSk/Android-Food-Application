package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ProductsListAdapter;
import com.example.youcare.appbody.Product;
import com.example.youcare.utils.Constants;
import com.example.youcare.utils.LocalStorage;

import java.util.ArrayList;
import java.util.List;

public class DisplayProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProducts;
    private List<Product> productsList;
    private ProductsListAdapter productsListAdapter;
    private TextView tv_noProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_products);
        recyclerViewProducts = findViewById(R.id.recyclerview_products);
        tv_noProducts = findViewById(R.id.tv_no_products);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewProducts.setLayoutManager(linearLayoutManager);

        productsList = new ArrayList<>();
        productsListAdapter = new ProductsListAdapter(this, productsList,tv_noProducts);

        String imageUrl = "https://www.google.com/search?q=Andechser+Molkerei+Scheitz+GmbH+image&sxsrf=ALeKk03uvCFFJqOFwdt6noA0iTphV8-DOg:1587832366446&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjawqjBgITpAhWoxzgGHbkBDGYQ_AUoA3oECAsQBQ&biw=1232&bih=553#imgrc=n6CylD3m4WDwsM";
        productsList.add(new Product("milk", "Demeter MilchBauern Schwarzwald-", "no", "yes", "yes", "no", 3, 3, "2.5", ""));
        productsList.add(new Product("milk", "Schwarzwaldmilch GmbH Freiburg", "no", "yes", "yes", "no", 2, 3, "1.5", ""));
        productsList.add(new Product("milk", "ARLA Foods Deutschl.GmbH/Hansa", "no", "yes", "yes", "no", 1, 3, "1", ""));
        productsList.add(new Product("milk", "Andechser Molkerei Scheitz GmbH", "no", "yes", "yes", "no", 2, 2, "1", ""));
        productsList.add(new Product("milk", "Milchw.Berchtesgad.Land Chiemgau eG", "no", "yes", "yes", "no", 2, 1, "2", ""));
        productsList.add(new Product("milk", "Alpro Comm. VA/SCA", "yes", "no", "yes", "yes", 2, 1, "2", ""));
        productsList.add(new Product("milk", "Oatly Germany GmbH", "yes", "no", "yes", "yes", 2, 3, "3", ""));
        productsList.add(new Product("choclate cream", "Rigoni di Asiago Nocciolata", "no", "yes", "yes", "no", 2, 1, "4.45", ""));
        productsList.add(new Product("choclate cream", "Franken Genuss Haselnuss-Nougat Ausftrich", "no", "yes", "yes", "no", 3, 0, "6.9", ""));
        productsList.add(new Product("choclate cream", "Nudossi", "no", "yes", "yes", "no", 2, 0, "2.99", ""));
        productsList.add(new Product("choclate cream", "Keimling vegane Schokocreme", "yes", "no", "yes", "yes", 2, 2, "8.95", ""));
        productsList.add(new Product("choclate cream", "Gepa Cocoba", "no", "yes", "yes", "no", 1, 2, "4.49", ""));
        productsList.add(new Product("choclate cream", "Bionella- Rapunzel", "yes", "no", "yes", "yes", 2, 1, "3.99", ""));
        productsList.add(new Product("choclate cream", "Rewe Bio Nuss-Nougat-Creme", "yes", "no", "yes", "yes", 2, 1, "2.99", ""));
        productsList.add(new Product("banana", "Bananen Chiquita kg", "no", "yes", "yes", "yes", 2, 0, "1.99", ""));
        productsList.add(new Product("banana", "K-Bio Bananen kg", "no", "yes", "yes", "yes", 1, 0, "2.29", ""));
        productsList.add(new Product("banana", "Rewe Beste Wahl", "no", "yes", "yes", "yes", 2, 0, "1.89", ""));
        productsList.add(new Product("banana", "Bananen Baby 250g St.", "no", "yes", "yes", "yes", 3, 0, "1.99", ""));
        productsList.add(new Product("banana", "Kochbananen kg", "no", "yes", "yes", "yes", 2, 3, "2.29", ""));
        productsList.add(new Product("banana", "Bananen kg", "no", "yes", "yes", "yes", 2, 3, "1.89", ""));
        productsList.add(new Product("banana", "Bananen Demeter kg", "no", "yes", "yes", "yes", 2, 2, "1.99", ""));


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
        productsListAdapter.filterProducts(filteredProducts);

}

    private int getRatingPreference(Context context, String ratingPreference) {
        return LocalStorage.getLocallyStoredRating(context, ratingPreference);
    }

    public String getProductPreference(Context context, String productId) {
        return LocalStorage.getLocallyStoredValue(context, productId);
    }

}
