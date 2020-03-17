package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeekBar extends AppCompatActivity {

    public Button shopping;
    public Button applyFilters;
    public String[] categories = {"Bio: ", "Recyclable: ", "Regional: ", "Seasonal: ", "Animal Treatment: ", "Co2 FootPrint: ", "Fair Trade: " };
    public android.widget.SeekBar seekBar1, seekBar2, seekBar3, seekBar4, seekBar5, seekBar6, seekBar7;
    public TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_seek_bar);
//        seekBar1 = findViewById(R.id.seekBar1); seekBar2 = findViewById(R.id.seekBar2);seekBar3 = findViewById(R.id.seekBar3);
//        seekBar4 = findViewById(R.id.seekBar4);seekBar5 = findViewById(R.id.seekBar5);seekBar6 = findViewById(R.id.seekBar6);
//        seekBar7 = findViewById(R.id.seekBar7);textView1 = findViewById(R.id.textView1);textView2 = findViewById(R.id.textView2);
//        textView3 = findViewById(R.id.textView3);textView4 = findViewById(R.id.textView4);textView5 = findViewById(R.id.textView5);
//        textView6 = findViewById(R.id.textView6); textView7 = findViewById(R.id.textView7);
//
//        seekBar1.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
//            int progressOfBar =0;
//            @Override
//            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
//                progressOfBar = progress;
//            }
//
//            @Override
//            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
//                textView1.setText(categories[0] + progressOfBar + "/" + seekBar.getMax());
//
//
//
//            }
//        });
//
//        seekBar2.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
//            int progressOfBar =0;
//            @Override
//            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
//                progressOfBar = progress;
//            }
//
//            @Override
//            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
//                textView2.setText(categories[1] + progressOfBar + "/" + seekBar.getMax());
//
//
//
//            }
//        });
//
//        seekBar3.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
//            int progressOfBar =0;
//            @Override
//            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
//                progressOfBar = progress;
//            }
//
//            @Override
//            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
//                textView3.setText(categories[2] + progressOfBar + "/" + seekBar.getMax());
//
//
//
//            }
//        });
//
//        seekBar4.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
//            int progressOfBar =0;
//            @Override
//            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
//                progressOfBar = progress;
//            }
//
//            @Override
//            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
//                textView4.setText(categories[3] + progressOfBar + "/" + seekBar.getMax());
//
//
//
//            }
//        });
//
//        seekBar5.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
//            int progressOfBar =0;
//            @Override
//            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
//                progressOfBar = progress;
//            }
//
//            @Override
//            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
//                textView5.setText(categories[4] + progressOfBar + "/" + seekBar.getMax());
//
//
//
//            }
//        });
//        seekBar6.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
//            int progressOfBar =0;
//            @Override
//            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
//                progressOfBar = progress;
//            }
//
//            @Override
//            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
//                textView6.setText(categories[5] + progressOfBar + "/" + seekBar.getMax());
//
//
//
//            }
//        });
//      seekBar7.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
//            int progressOfBar =0;
//            @Override
//            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
//                progressOfBar = progress;
//            }
//
//            @Override
//            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
//                textView7.setText(categories[6] + progressOfBar + "/" + seekBar.getMax());
//
//
//
//            }
//        });
//
//
//        shopping = findViewById(R.id.saveAndContinueButton);
//        shopping.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(SeekBar.this, ShoppingSearchBar.class));
//                }
//
//        });
    }
}