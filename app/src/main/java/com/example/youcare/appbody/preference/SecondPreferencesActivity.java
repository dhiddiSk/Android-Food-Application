package com.example.youcare.appbody.preference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.youcare.R;

public class SecondPreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    private Button kaufland;
    private Button lidl;
    private Button rewe;
    private Button penny;
    private Button edeka;
    private Button netto;
    private boolean kauflandchecked = false;
    private boolean lidlchecked = false;
    private boolean rewechecked = false;
    private boolean pennychecked = false;
    private boolean edekachecked = false;
    private boolean nettochecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefrence_child_one);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_store);
        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);
        kaufland = findViewById(R.id.kauflandsupermarket);
        lidl = findViewById(R.id.lidlsupermarket);
        rewe = findViewById(R.id.rewesupermarket);
        penny = findViewById(R.id.pennysupermarket);
        edeka = findViewById(R.id.edekasupermarket);
        netto = findViewById(R.id.nettosupermarket);
        kaufland.setOnClickListener(this);
        lidl.setOnClickListener(this);
        rewe.setOnClickListener(this);
        penny.setOnClickListener(this);
        edeka.setOnClickListener(this);
        netto.setOnClickListener(this);
        findViewById(R.id.button_continueshop).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.kauflandsupermarket:
                kauflandchecked = (!kauflandchecked);
                int marketResId = (kauflandchecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
                kaufland.setBackgroundResource(marketResId);
                break;

            case R.id.lidlsupermarket:
                lidlchecked = (!lidlchecked);
                int lidlResId = (lidlchecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
                lidl.setBackgroundResource(lidlResId);
                break;

            case R.id.rewesupermarket:
                rewechecked = (!rewechecked);
                int reweResId = (rewechecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
                rewe.setBackgroundResource(reweResId);
                break;

            case R.id.pennysupermarket:
                pennychecked = (!pennychecked);
                int pennyeResId = (pennychecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
                penny.setBackgroundResource(pennyeResId);
                break;

            case R.id.edekasupermarket:
                edekachecked = (!edekachecked);
                int edekaResId = (edekachecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
                edeka.setBackgroundResource(edekaResId);
                break;
            case R.id.nettosupermarket:
                nettochecked = (!nettochecked);
                int nettoResId = (nettochecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
                netto.setBackgroundResource(nettoResId);
                break;

            case R.id.button_continueshop:
                Intent it = new Intent(SecondPreferencesActivity.this, ThirdPreferencesActivity.class);
                startActivity(it);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
