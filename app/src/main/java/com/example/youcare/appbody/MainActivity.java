package com.example.youcare.appbody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.youcare.R;
import com.example.youcare.appbody.search.Searchproducts;
import com.example.youcare.appbody.preference.PreferenceFragment;
import com.example.youcare.authentication.LoginActivity;
import com.example.youcare.utils.LocalStorage;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_body_navigation_main);
//        //getting the toolbar
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        //setting the title
//        toolbar.setTitle("My Toolbar");
//        //placing toolbar in place of actionbar
//        setSupportActionBar(toolbar);

        bottomNavigation = findViewById(R.id.body_bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(new PreferenceFragment());
    }


    public void openFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.bodycontainer, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }


    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_favorites:
                            openFragment(new PreferenceFragment());
                            return true;
                        case R.id.navigation_search:
                            Intent i = new Intent(MainActivity.this, Searchproducts.class);
                            startActivity(i);
                            return true;
                        case R.id.navigation_deal:
                            openFragment(new DealFragment());
                            return true;
                        case R.id.navigation_nav_shop:
                            openFragment(new ShopFragment());
                            return true;
                    }
                    return false;
                }
            };

    @Override
    public void onBackPressed() {
        if (bottomNavigation.getSelectedItemId() == R.id.navigation_favorites) {
            finish();
        } else {
            bottomNavigation.setSelectedItemId(R.id.navigation_favorites);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return true;
    }

}
