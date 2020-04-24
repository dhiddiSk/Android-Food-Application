package com.example.youcare.appbody.preference;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.youcare.R;

public class PreferenceFragment extends Fragment implements View.OnClickListener {

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
       // nextpage.setOnClickListener(this);
        vegetarian.setOnClickListener(this);
        vegan.setOnClickListener(this);
        glutenfree.setOnClickListener(this);
        lacktosefree.setOnClickListener(this);
        norestrictions.setOnClickListener(this);
        nextpage = view.findViewById(R.id.nextPage);

        return view;
    }

    private boolean vegTempChecked = false;
    private boolean veganTempChecked = false;
    private boolean glutemTempChecked = false;
    private boolean lacktoTempChecked = false;
    private boolean norestrictionChecked = false;

    @Override
    public void onClick(View v) {


          switch (v.getId()){

                   case R.id.Vegetarian : vegTempChecked = (!vegTempChecked);
                                          int vegResId =  (vegTempChecked ? R.drawable.preference_button_shape_green:R.drawable.preference_body_button_shape);
                                          vegetarian.setBackgroundResource(vegResId);
                                          break;
                        case R.id.Vegan : veganTempChecked = (!veganTempChecked);
                                          int veganResId =  (veganTempChecked ? R.drawable.preference_button_shape_green:R.drawable.preference_body_button_shape);
                                          vegan.setBackgroundResource(veganResId);
                                          break;

                    case R.id.GlutenFree : glutemTempChecked = (!glutemTempChecked);
                                            int GlutenResId =  (glutemTempChecked ? R.drawable.preference_button_shape_green:R.drawable.preference_body_button_shape);
                                            glutenfree.setBackgroundResource(GlutenResId);
                                            break;

                   case R.id.LacktoseFree : lacktoTempChecked = (!lacktoTempChecked);
                                            int lacktoResId =  (lacktoTempChecked ? R.drawable.preference_button_shape_green:R.drawable.preference_body_button_shape);
                                            lacktosefree.setBackgroundResource(lacktoResId);
                                            break;

                   case R.id.Norestrictions: norestrictionChecked = (!norestrictionChecked);
                                             int restrictionResId =  (norestrictionChecked ? R.drawable.preference_button_shape_green:R.drawable.preference_body_button_shape);
                                             norestrictions.setBackgroundResource(restrictionResId);
                                             break;


                //
                // color.colorPrimaryDark));

                //case R.id.Vegetarian : vegetarian.setBackground();

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

                Intent it = new Intent(getActivity(), FragmentChildActivityOne.class);
                  startActivity(it);

//                FragmentManager fm = getChildFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.preferenceSubfragmentOneContainer, new FragmentChildActivityOne());
//                ft.commit();

            }
        });


    }

}
