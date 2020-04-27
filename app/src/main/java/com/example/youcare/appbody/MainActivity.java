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

import com.example.youcare.DisplayProductsActivity;
import com.example.youcare.R;
import com.example.youcare.appbody.search.DisplayProductsFragment;
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_body);
//        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);

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
