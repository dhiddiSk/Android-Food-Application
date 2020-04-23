package com.example.youcare.appbody.preference;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.youcare.R;

public class FragmentChildActivityOne extends AppCompatActivity {

    ImageButton nextpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefrence_child_one);

    }


    @Override
    protected void onResume(){
        super.onResume();
      nextpage = findViewById(R.id.nextPage);

      nextpage.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent it = new Intent(FragmentChildActivityOne.this, FragmentChildActivityTwo.class);
               startActivity(it);
          }
      });




    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace()
//
//
//
//    }
}
