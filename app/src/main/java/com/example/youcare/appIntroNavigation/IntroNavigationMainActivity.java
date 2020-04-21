package com.example.youcare.appIntroNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.youcare.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class IntroNavigationMainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_navigation);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(new IntroNavigationPreferenceFragment());

    }
    public void openFragment(Fragment fragment){
        FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_favorites:
                        openFragment(new IntroNavigationPreferenceFragment());
                            break;
                        case R.id.navigation_search:
                          openFragment(new IntroNavigationSearchFragment());
                          return true;
                        case R.id.navigation_deal:
                            openFragment(new IntroNavigationDealFragment());
                            return true;
                        case R.id.navigation_nav_shop:
                            openFragment(new IntroNavigationBasketFragment());
                             return true;
                    }
                    return false;
                }
            };
}
