package com.example.youcare.appbody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.youcare.R;
import com.example.youcare.appbody.search.DisplayProductsFragment;
import com.example.youcare.appbody.preference.FirstPreferenceFragment;
import com.example.youcare.appintro.SearchFragment;
import com.example.youcare.utils.LocalStorage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_body_navigation_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_body);
        setSupportActionBar(toolbar);

        bottomNavigation = findViewById(R.id.body_bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            boolean isPreferencesSelected = bundle.getBoolean("isPreferenceSelected");
            if (isPreferencesSelected){
                openFragment(new DisplayProductsFragment());
            }else{
                openFragment(new FirstPreferenceFragment());
            }
        }else{
            openFragment(new FirstPreferenceFragment());
        }
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
                            openFragment(new FirstPreferenceFragment());
                            return true;
                        case R.id.navigation_search:
                            openFragment(new DisplayProductsFragment());
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
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuProfile:
                // Retriving from session
                showDialog(1,this,LocalStorage.getLocallyStoredValue(this, "username"),LocalStorage.getLocallyStoredValue(this, "password"),"Cancel","Dismiss");
                break;

            case R.id.menuLogout:
                showDialog(2,this,LocalStorage.getLocallyStoredValue(this, "username"),LocalStorage.getLocallyStoredValue(this, "password"),"Cancel","Logout");
                break;
        }
        return true;
    }

    private void showDialog(int type, Context context, String username, String password,String leftOption, String rightOption) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String title = "";
        String message = "";
        if (type == 1) {
            // user profile
            title = "User Profile";
            //TODO : Save all user info here and show to user profile from preferences
            message = "Name: "+ username +"\n"+"Password: "+password;

        }else if (type == 2){
            title = "Logout";
            message = "Are you sure, You want to Logout?";
        }

        //Setting message manually and performing action on button click
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        LocalStorage.clearPreferences(context); //clearing preferences
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle(title);
        alert.show();

    }

}
