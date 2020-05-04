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
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.youcare.R;
import com.example.youcare.appbody.search.Searchproducts;
import com.example.youcare.authentication.LoginActivity;
import com.example.youcare.utils.LocalStorage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FirstPreferenceFragment extends Fragment implements View.OnClickListener {

    //@button_continuepreference is to continue to the next screen
   // private Button button_continuepreference;
    //@vegetarian, @vegan, @glutenfree, @lacktosefree, @norestrictions refers to one of the user preference.
    private Button vegetarian;
    private Button vegan;
    private Button glutenfree;
    private Button lacktosefree;
    //@norestriction refers to user has no food restrictions
    private Button norestrictions;
    // @vegUserInput,@veganUserInput,@glutenUserInput,@lacktoUserInput are the local veriables to store the states of the user preferences and store them in variable.
    public String vegUserInput = "no";
    public String veganUserInput = "no";
    public String glutenUserInput = "no";
    public String lacktoUserInput = "no";
    //@applyRestrictionsOnUserRecommendations is opposite to no restrictions, and used to query if the user has any restrictions or not.
    public String applyRestrictionsOnUserRecommendations = "no";

    private FrameLayout framelayout_prefernce;
    private String TAG = "ButtonWorking";
    private View view;
    LinearLayout button_continuepreference;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_app_body_navigation_preference_fragment, container, false);

        framelayout_prefernce = view.findViewById(R.id.framelayout_prefernce);
        vegetarian = view.findViewById(R.id.Vegetarian);
        vegan = view.findViewById(R.id.Vegan);
        glutenfree = view.findViewById(R.id.GlutenFree);
        lacktosefree = view.findViewById(R.id.LacktoseFree);
        norestrictions = view.findViewById(R.id.Norestrictions);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vegetarian.setOnClickListener(this::onClick);
        vegan.setOnClickListener(this::onClick);
        glutenfree.setOnClickListener(this::onClick);
        lacktosefree.setOnClickListener(this::onClick);
        norestrictions.setOnClickListener(this::onClick);
        button_continuepreference = view.findViewById(R.id.button_continuepreference);
        button_continuepreference.setOnClickListener(this::onClick);
    }


    @Override
    public void onClick(View v) {
        boolean vegTempChecked = false;
        boolean veganTempChecked = false;
        boolean glutenTempChecked = false;
        boolean lacktoTempChecked = false;
        boolean norestrictionChecked = false;


        switch (v.getId()) {

            case R.id.Vegetarian:  vegTempChecked = !vegTempChecked;
                //int vegResId = (vegTempChecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);

                if (!vegTempChecked) {
                    vegetarian.setBackgroundResource(R.drawable.preference_body_button_shape);
                    vegUserInput = "no";                                    }


                else if((!vegTempChecked)&&(!veganTempChecked)&&(!glutenTempChecked)&&(!lacktoTempChecked)){
                    applyRestrictionsOnUserRecommendations ="no";
                    norestrictions.setBackgroundResource(R.drawable.preference_button_shape_green);
                }

                if (vegTempChecked){
                    vegUserInput = "yes";
                    vegetarian.setBackgroundResource(R.drawable.preference_button_shape_green);
                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);
                    applyRestrictionsOnUserRecommendations = "yes";
                }


                break;


            case R.id.Vegan:     veganTempChecked = !veganTempChecked;
//                                int veganResId = (veganTempChecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
//                                vegan.setBackgroundResource(veganResId);
//                                if (!veganTempChecked) {
//                                    veganUserInput = "no";
//                                } else {
//                                    veganUserInput = "yes";
//                                    applyRestrictionsOnUserRecommendations = "yes";
//                                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);
//                                }
                if (!veganTempChecked) {
                    vegan.setBackgroundResource(R.drawable.preference_body_button_shape);
                    veganUserInput = "no";
                }

                else if (veganTempChecked){
                    veganUserInput = "yes";
                    vegan.setBackgroundResource(R.drawable.preference_button_shape_green);
                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);
                    applyRestrictionsOnUserRecommendations = "yes";
                }
                else if((!vegTempChecked)&&(!veganTempChecked)&&(!glutenTempChecked)&&(!lacktoTempChecked)){

                    applyRestrictionsOnUserRecommendations = "no";
                    norestrictions.setBackgroundResource(R.drawable.preference_button_shape_green);
                }

                break;

            case R.id.GlutenFree: glutenTempChecked = !glutenTempChecked;
//                    int GlutenResId = (glutenTempChecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
//                    glutenfree.setBackgroundResource(GlutenResId);
//                    if (!glutenTempChecked) {
//                        glutenUserInput = "no";
//                    } else {
//                        glutenUserInput = "yes";
//                        applyRestrictionsOnUserRecommendations = "yes";
//                        norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);
//                    }
                if (!glutenTempChecked) {
                    glutenfree.setBackgroundResource(R.drawable.preference_body_button_shape);
                    glutenUserInput = "no";
                }

                else if (glutenTempChecked){
                    glutenUserInput = "yes";
                    glutenfree.setBackgroundResource(R.drawable.preference_button_shape_green);
                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);
                    applyRestrictionsOnUserRecommendations = "yes";
                }
                else if((!vegTempChecked)&&(!veganTempChecked)&&(!glutenTempChecked)&&(!lacktoTempChecked)){

                    applyRestrictionsOnUserRecommendations ="no";
                    norestrictions.setBackgroundResource(R.drawable.preference_button_shape_green);
                }


                break;

            case R.id.LacktoseFree:  lacktoTempChecked = !lacktoTempChecked;
//                int lacktoResId = (lacktoTempChecked ? R.drawable.preference_button_shape_green : R.drawable.preference_body_button_shape);
//                lacktosefree.setBackgroundResource(lacktoResId);
//                if (!lacktoTempChecked) {
//                    lacktoUserInput = "no";
//                } else {
//                    lacktoUserInput = "yes";
//                    applyRestrictionsOnUserRecommendations = "yes";
//                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);
//                }
                if (!lacktoTempChecked) {
                    lacktosefree.setBackgroundResource(R.drawable.preference_body_button_shape);
                    lacktoUserInput = "no";
                }

                else if (lacktoTempChecked){
                    lacktoUserInput = "yes";
                    lacktosefree.setBackgroundResource(R.drawable.preference_button_shape_green);
                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);
                    applyRestrictionsOnUserRecommendations = "yes";
                }
                else if((!vegTempChecked)&&(!veganTempChecked)&&(!glutenTempChecked)&&(!lacktoTempChecked)){

                    applyRestrictionsOnUserRecommendations ="no";
                    norestrictions.setBackgroundResource(R.drawable.preference_button_shape_green);
                }

                break;

            case R.id.Norestrictions:  norestrictionChecked = !norestrictionChecked;
                //int restrictionResId =  (norestrictionChecked ? R.drawable.preference_button_shape_green:R.drawable.preference_body_button_shape);
                //norestrictions.setBackgroundResource(restrictionResId);

                if (norestrictionChecked) {
                    applyRestrictionsOnUserRecommendations = "no";
                    vegUserInput="no";
                    veganUserInput="no";
                    glutenUserInput="no";
                    lacktoUserInput="no";
                    norestrictions.setBackgroundResource(R.drawable.preference_button_shape_green);
                    vegetarian.setBackgroundResource(R.drawable.preference_body_button_shape);
                    vegan.setBackgroundResource(R.drawable.preference_body_button_shape);
                    lacktosefree.setBackgroundResource(R.drawable.preference_body_button_shape);
                    glutenfree.setBackgroundResource(R.drawable.preference_body_button_shape);

                }

                else  if ((!norestrictionChecked) && (lacktoTempChecked) && (glutenTempChecked) && (veganTempChecked) && (vegTempChecked)) {
                    applyRestrictionsOnUserRecommendations = "yes";
                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);

                }
                else  if ((!norestrictionChecked) && ((lacktoTempChecked) || (glutenTempChecked) || (veganTempChecked) || (vegTempChecked))) {
                    applyRestrictionsOnUserRecommendations = "yes";
                    norestrictions.setBackgroundResource(R.drawable.preference_body_button_shape);
                }
                break;

            case R.id.button_continuepreference:
                System.out.println("--->>> "+ vegUserInput + veganUserInput+ glutenUserInput +lacktoUserInput + applyRestrictionsOnUserRecommendations);
                //Clearing Previously Selected Preferences
                LocalStorage.removeUserPreferences(v.getContext()); // clear

                //saving to local preferences
                String userId = LocalStorage.getLocallyStoredValue(getActivity(),"email");
                LocalStorage.storeUserPrefernces(getActivity(),userId, veganUserInput, vegUserInput, glutenUserInput, lacktoUserInput, applyRestrictionsOnUserRecommendations);

                Intent it = new Intent(getActivity(), SecondPreferencesActivity.class);
                getActivity().startActivity(it);
                break;
        }


    }

    @Override
    public void onStart() {
        super.onStart();
        if (view != null){
            view.setWillNotDraw(false);
            view.invalidate();
            System.out.println("---> invalidate in fragment");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("---> pause in fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("---> stop in fragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("---> resume in fragment");
    }



}
