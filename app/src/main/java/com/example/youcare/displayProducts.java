package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class displayProducts extends AppCompatActivity {

    public TextView tv;




    String productTxt;
    public void getdisplayProducts(String displayProduct) {
      productTxt = displayProduct;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tv = findViewById(R.id.priceView);
        setContentView(R.layout.activity_display_products);
          tv.setText(productTxt);



    }
}
