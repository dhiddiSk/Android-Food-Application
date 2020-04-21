package com.example.youcare.appBodyNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.youcare.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppBodyNavigationMainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_body_navigation_main);
        bottomNavigation = findViewById(R.id.body_bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }


    public void openFragment(Fragment fragment){
        FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.bodycontainer, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }


    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_favorites:
                            openFragment(new AppBodyNavigationpreferenceFragment());
                            break;
                        case R.id.navigation_search:
                            openFragment(new AppBodyNavigationSearchFragment());
                            return true;
                        case R.id.navigation_deal:
                            openFragment(new AppBodyNavigationDealFragment());
                            return true;
                        case R.id.navigation_nav_shop:
                            openFragment(new AppBodyNavigationBasketFragment());
                            return true;
                    }
                    return false;
                }
            };



}
