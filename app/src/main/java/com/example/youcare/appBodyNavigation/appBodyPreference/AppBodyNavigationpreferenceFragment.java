package com.example.youcare.appBodyNavigation.appBodyPreference;

import androidx.annotation.Nullable;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.youcare.R;
import com.example.youcare.appBodyNavigation.appBodyPreference.PrefrenceChildActivityOne;

public class AppBodyNavigationpreferenceFragment extends Fragment {

    ImageButton nextpage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_app_body_navigation_preference_fragment, container, false);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nextpage = view.findViewById(R.id.nextPage);
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
