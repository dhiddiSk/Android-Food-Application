package com.example.youcare.appBodyNavigation.appBodyPreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.youcare.R;

public class PrefrenceChildActivityOne extends AppCompatActivity {

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
              Intent it = new Intent(PrefrenceChildActivityOne.this, PreferenceChildActivityTwo.class);
               startActivity(it);
          }
      });




    }
}
