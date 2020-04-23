package com.example.youcare.appbody.preference;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.youcare.R;
import com.example.youcare.appbody.MainActivity;

public class FragmentChildActivityTwo extends AppCompatActivity {
   Button Save;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_child_two);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Save = findViewById(R.id.SaveButton);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FragmentChildActivityTwo.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}

