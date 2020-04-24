package com.example.youcare.appbody.preference;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.youcare.R;

public class FragmentChildActivityOne extends AppCompatActivity implements View.OnClickListener{

    ImageButton nextpage;
    Button market;
    Button store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefrence_child_one);
        market = findViewById(R.id.supermarket);
        store = findViewById(R.id.onlineStore);
        nextpage = findViewById(R.id.nextPage);
        market.setOnClickListener(this);
        store.setOnClickListener(this);
        nextpage.setOnClickListener(this);

    }


   private boolean supermarketChecked = false;
    private boolean onlinestoresChecked = false;


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.supermarket : supermarketChecked = (!supermarketChecked);
                                    int marketResId =  (supermarketChecked ? R.drawable.preference_button_shape_green:R.drawable.preference_body_button_shape);
                                    market.setBackgroundResource(marketResId);
                                    break;

            case R.id.onlineStore : onlinestoresChecked = (!onlinestoresChecked);
                                     int onlineResId = (onlinestoresChecked ? R.drawable.preference_button_shape_green:R.drawable.preference_body_button_shape);
                                     store.setBackgroundResource(onlineResId);
                                     break;


             case R.id.nextPage :   Intent it = new Intent(FragmentChildActivityOne.this, FragmentChildActivityTwo.class);
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
//    }
}
