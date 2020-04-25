package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.TextView;

import com.example.ProductsListAdapter;
import com.example.youcare.appbody.Product;

import java.util.ArrayList;
import java.util.List;

public class DisplayProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProducts;
    private List<Product> productsList;
    private ProductsListAdapter productsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_products);
        recyclerViewProducts = findViewById(R.id.recyclerview_products);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewProducts.setLayoutManager(linearLayoutManager);

        productsList = new ArrayList<>();
        productsListAdapter = new ProductsListAdapter(this,productsList);

        String imageUrl = "https://www.google.com/search?q=Andechser+Molkerei+Scheitz+GmbH+image&sxsrf=ALeKk03uvCFFJqOFwdt6noA0iTphV8-DOg:1587832366446&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjawqjBgITpAhWoxzgGHbkBDGYQ_AUoA3oECAsQBQ&biw=1232&bih=553#imgrc=n6CylD3m4WDwsM";
        productsList.add(new Product("Milk","Andechser Molkerei Scheitz GmbH","No","yes","yes","no","2","3","1.5",imageUrl));
        productsList.add(new Product("Milk","Andechser Molkerei Scheitz GmbH","No","yes","yes","no","2","3","1.5",imageUrl));
        productsList.add(new Product("Milk","Andechser Molkerei Scheitz GmbH","No","yes","yes","no","2","3","1.5",imageUrl));

        recyclerViewProducts.setAdapter(productsListAdapter);
        productsListAdapter.notifyDataSetChanged();
    }
}
