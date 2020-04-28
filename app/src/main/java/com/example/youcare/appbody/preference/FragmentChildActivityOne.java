package com.example.youcare.appbody.preference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.youcare.R;
import com.example.youcare.appbody.search.Searchproducts;

public class FragmentChildActivityOne extends AppCompatActivity implements View.OnClickListener {

    private Button market;
    private Button store;
    private boolean supermarketChecked = false;
    private boolean onlinestoresChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefrence_child_one);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_store);
//        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);
        market = findViewById(R.id.supermarket);
        store = findViewById(R.id.onlineStore);
        market.setOnClickListener(this);
        store.setOnClickListener(this);
        findViewById(R.id.button_continueshop).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.supermarket:
                supermarketChecked = (!supermarketChecked);
                int marketResId = (supermarketChecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
                market.setBackgroundResource(marketResId);
                break;

            case R.id.onlineStore:
                onlinestoresChecked = (!onlinestoresChecked);
                int onlineResId = (onlinestoresChecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
                store.setBackgroundResource(onlineResId);
                break;


            case R.id.button_continueshop:



                Intent it = new Intent(FragmentChildActivityOne.this, FragmentChildActivityTwo.class);
                startActivity(it);
                break;
        }


    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace()
//
//
//


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
