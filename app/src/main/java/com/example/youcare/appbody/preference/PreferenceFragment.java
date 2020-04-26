package com.example.youcare.appbody.preference;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.youcare.R;
import com.example.youcare.appbody.search.Searchproducts;
import com.example.youcare.authentication.LoginActivity;
import com.example.youcare.utils.LocalStorage;

public class PreferenceFragment extends Fragment implements View.OnClickListener {

    ImageButton nextpage;
    Button vegetarian;
    Button vegan;
    Button glutenfree;
    Button lacktosefree;
    Button norestrictions;
    public String vegUserInput = null;
    public String veganUserInput = null;
    public String glutenUserInput = null;
    public String lacktoUserInput = null;
    public String applyRestrictionsOnUserRecommendations = null;


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
        view.findViewById(R.id.userProfile).setOnClickListener(this);
        view.findViewById(R.id.userLogout).setOnClickListener(this);

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
                    applyRestrictionsOnUserRecommendations = "no";
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
            case R.id.userProfile:
                // Retriving from session

                    showDialog(1, v.getContext(), LocalStorage.getLocallyStoredValue(v.getContext(), "username"), LocalStorage.getLocallyStoredValue(v.getContext(), "password"), "Cancel", "Dismiss");
                break;

            case R.id.userLogout:
                showDialog(2, getActivity(), LocalStorage.getLocallyStoredValue(getActivity(), "username"), LocalStorage.getLocallyStoredValue(getActivity(), "password"), "Cancel", "Logout");
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

        Searchproducts searchobj = new Searchproducts();
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchobj.userEatingHabits(vegUserInput, veganUserInput, glutenUserInput, lacktoUserInput, applyRestrictionsOnUserRecommendations);

                Intent it = new Intent(getActivity(), FragmentChildActivityOne.class);
                startActivity(it);

//                FragmentManager fm = getChildFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.preferenceSubfragmentOneContainer, new FragmentChildActivityOne());
//                ft.commit();

            }
        });


    }

    private void showDialog(int type, Context context, String username, String password, String leftOption, String rightOption) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (type == 1) {
            // user profile
            builder.setTitle("User Profile");
            //TODO : Save all user info here and show to user profile from preferences
            builder.setMessage("Name: " + username + "\n" + "Password: " + password);

        } else if (type == 2) {
            builder.setTitle("Logout");
            //TODO : Save all user info here and show to user profile from preferences
            builder.setMessage("Are you sure, You want to Logout");
        }

        //Setting message manually and performing action on button click
        builder.setMessage("")
                .setCancelable(false)
                .setPositiveButton(rightOption, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (type == 2) {
                            LocalStorage.clearPreferences(context.getApplicationContext()); //clearing preferences
                            context.startActivity(new Intent(getActivity(), LoginActivity.class));
                            getActivity().finish();
                            Toast.makeText(context.getApplicationContext(), "Logged out!", Toast.LENGTH_SHORT).show();
                        } else {
                            if (dialog != null) dialog.dismiss();
                        }
                    }
                })
                .setNegativeButton(leftOption, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle(getResources().getText(R.string.app_name));
        alert.show();

    }


}
