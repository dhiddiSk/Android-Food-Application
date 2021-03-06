package com.example.youcare.appintro;

import androidx.annotation.Nullable;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.youcare.R;
import com.example.youcare.authentication.LoginActivity;

public class DealFragment extends Fragment {
    LinearLayout verifyNow;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_intro_navigation_deal_fragment, container, false);

        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        verifyNow = view.findViewById(R.id.dealverifynow);
    }

    @Override
    public void onResume() {
        super.onResume();


        verifyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });


    }
}
