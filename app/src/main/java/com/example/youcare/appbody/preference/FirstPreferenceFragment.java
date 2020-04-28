package com.example.youcare.appbody.preference;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.youcare.R;
import com.example.youcare.appbody.search.Searchproducts;
import com.example.youcare.authentication.LoginActivity;
import com.example.youcare.utils.LocalStorage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FirstPreferenceFragment extends Fragment implements View.OnClickListener {

    private Button button_continuepreference;
    private Button vegetarian;
    private Button vegan;
    private Button glutenfree;
    private Button lacktosefree;
    private Button norestrictions;
    public String vegUserInput = "no";
    public String veganUserInput = "no";
    public String glutenUserInput = "no";
    public String lacktoUserInput = "no";
    public String applyRestrictionsOnUserRecommendations = "yes";
    private FrameLayout framelayout_prefernce;
    private String TAG = "ButtonWorking";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_app_body_navigation_preference_fragment, container, false);

        framelayout_prefernce = view.findViewById(R.id.framelayout_prefernce);
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
        button_continuepreference = view.findViewById(R.id.button_continuepreference);
        button_continuepreference.setOnClickListener(this::onClick);

        return view;
    }

    private boolean vegTempChecked = false;
    private boolean veganTempChecked = false;
    private boolean glutenTempChecked = false;
    private boolean lacktoTempChecked = false;
    private boolean norestrictionChecked = false;

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.Vegetarian:
                vegTempChecked = (!vegTempChecked);
                int vegResId = (vegTempChecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
                vegetarian.setBackgroundResource(vegResId);
                if (!vegTempChecked) {
                    vegUserInput = "no";

                } else {
                    vegUserInput = "yes";

                    applyRestrictionsOnUserRecommendations = "yes";
                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);
                }
                break;
            case R.id.Vegan:
                veganTempChecked = (!veganTempChecked);
                int veganResId = (veganTempChecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
                vegan.setBackgroundResource(veganResId);
                if (!veganTempChecked) {
                    veganUserInput = "no";
                } else {
                    veganUserInput = "yes";
                    applyRestrictionsOnUserRecommendations = "yes";
                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);
                }
                break;

            case R.id.GlutenFree:
                glutenTempChecked = (!glutenTempChecked);
                int GlutenResId = (glutenTempChecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
                glutenfree.setBackgroundResource(GlutenResId);
                if (!glutenTempChecked) {
                    glutenUserInput = "no";
                } else {
                    glutenUserInput = "yes";
                    applyRestrictionsOnUserRecommendations = "yes";
                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);
                }
                break;

            case R.id.LacktoseFree:
                lacktoTempChecked = (!lacktoTempChecked);
                int lacktoResId = (lacktoTempChecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
                lacktosefree.setBackgroundResource(lacktoResId);
                if (!lacktoTempChecked) {
                    lacktoUserInput = "no";
                } else {
                    lacktoUserInput = "yes";
                    applyRestrictionsOnUserRecommendations = "yes";
                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);
                }
                break;

            case R.id.Norestrictions:
                norestrictionChecked = (!norestrictionChecked);
                //int restrictionResId =  (norestrictionChecked ? R.drawable.preference_button_shape_green:R.drawable.preference_body_button_shape);
                //norestrictions.setBackgroundResource(restrictionResId);

                if (norestrictionChecked) {
                    applyRestrictionsOnUserRecommendations = "yes";
                    veganUserInput = "yes";
                    veganUserInput="yes";
                    glutenUserInput="yes";
                    lacktoUserInput="yes";

                    norestrictions.setBackgroundResource(R.drawable.preference_button_shape_green);
                    vegetarian.setBackgroundResource(R.drawable.preference_body_button_shape);
                    vegan.setBackgroundResource(R.drawable.preference_body_button_shape);
                    lacktosefree.setBackgroundResource(R.drawable.preference_body_button_shape);
                    glutenfree.setBackgroundResource(R.drawable.preference_body_button_shape);


                }
                if ((!norestrictionChecked) && (lacktoTempChecked) && (glutenTempChecked) && (veganTempChecked) && (vegTempChecked)) {

                    applyRestrictionsOnUserRecommendations = "yes";
                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);

                }

                if ((!norestrictionChecked) && ((lacktoTempChecked) || (glutenTempChecked) || (veganTempChecked) || (vegTempChecked))) {
                    applyRestrictionsOnUserRecommendations = "yes";
                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);

                }
                break;

            case R.id.button_continuepreference:
                String userId = LocalStorage.getLocallyStoredValue(getActivity(),"email");
                System.out.println(" --- >> userid "+userId);
                LocalStorage.storeUserPrefernces(getActivity(),userId, veganUserInput, vegUserInput, glutenUserInput, lacktoUserInput, applyRestrictionsOnUserRecommendations);

                System.out.println(" ---> values " + vegUserInput + veganUserInput + glutenUserInput + lacktoUserInput +  applyRestrictionsOnUserRecommendations);

//                Searchproducts searchobj = new Searchproducts();
//                searchobj.userEatingHabits(vegUserInput, veganUserInput, glutenUserInput, lacktoUserInput, applyRestrictionsOnUserRecommendations);
                Intent it = new Intent(getActivity(), SecondPreferencesActivity.class);
                getActivity().startActivity(it);
//                FragmentManager fm = getActivity().getFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.framelayout_prefernce, new StoresOnlineFragment());
//                ft.commit();
                break;
        }


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    @Override
    public void onResume() {
        super.onResume();
    }

}
