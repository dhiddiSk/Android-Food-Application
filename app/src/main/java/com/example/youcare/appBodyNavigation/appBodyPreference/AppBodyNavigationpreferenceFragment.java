package com.example.youcare.appBodyNavigation.appBodyPreference;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.youcare.R;
import com.example.youcare.appBodyNavigation.appBodyPreference.PrefrenceChildActivityOne;

public class AppBodyNavigationpreferenceFragment extends Fragment implements View.OnClickListener {

    ImageButton nextpage;
    Button vegetarian;
    Button vegan;
    Button glutenfree;
    Button lacktosefree;
    Button norestrictions;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_app_body_navigation_preference_fragment, container, false);


        vegetarian = view.findViewById(R.id.Vegetarian);
        vegan = view.findViewById(R.id.Vegan);
        glutenfree = view.findViewById(R.id.GlutenFree);
        lacktosefree = view.findViewById(R.id.LacktoseFree);
        norestrictions = view.findViewById(R.id.Norestrictions);
        nextpage.setOnClickListener(this);
        vegetarian.setOnClickListener(this);
        vegan.setOnClickListener(this);
        glutenfree.setOnClickListener(this);
        lacktosefree.setOnClickListener(this);
        norestrictions.setOnClickListener(this);
        nextpage = view.findViewById(R.id.nextPage);

        return view;
    }


    @Override
    public void onClick(View v) {

            switch (v.getId()){

               // case R.id.Vegetarian : vegetarian.setBackgroundColor("@colors/");



            }



    }




    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }






    @Override
    public void onResume() {
        super.onResume();


        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getActivity(), PrefrenceChildActivityOne.class);
                  startActivity(it);

//                FragmentManager fm = getChildFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.preferenceSubfragmentOneContainer, new PrefrenceChildActivityOne());
//                ft.commit();

            }
        });


    }



}
