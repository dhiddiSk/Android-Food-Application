package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
This class refers to the eating habits of the user like vegan and vegetarian.
 */


public class eatinghabits extends AppCompatActivity {


    /*
    @parameters SeekBar and textView are used to show about the seekbar and use the seekbars.
     */
//    public Button applyFilters;
//    public String[] categories = {"Vegan: ", "Vegetarian: "};
//    public android.widget.SeekBar seekBar1,seekBar2;
//    public TextView textView1, textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_eating_behaviour);}}
//        seekBar1 = findViewById(R.id.seekBar1); // initiate the first Seek bar
//        seekBar2 = findViewById(R.id.seekBar2); // initiate the second Seek bar
//        textView1 = findViewById(R.id.textView1);
//        textView2 = findViewById(R.id.textView2);
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
//
//        seekBar2.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
//
//             int progressOfBar = 0;
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
//              textView2.setText(categories[1] + progressOfBar + "/" + seekBar.getMax());
//            }
//        });
//
//        applyFilters = findViewById(R.id.ApplyFilters);
//        applyFilters.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(eatinghabits.this, SecondSeekBar.class));
//            }
//
//        });
//
//
//
//
//    }
        // Initialize the textview with '0'.
        /*
        Here with below setText method sends the values of the progress obtained from teh method getProgress method and are reflexted in teh layour
         */
//        textView.setText("Vegan: " + seekBar.getProgress() + "/" + seekBar.getMax());

       // seekBar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
           // int progress = 0;



//            @Override
//            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
//               // Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
//                textView.setText(categories[i] + progress + "/" + seekBar.getMax());
//               // Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
//                //from here I can catch up with next filter.
//
//            }


//        //);
//        applyFilters=findViewById(R.id.saveAndContinueButton);
//        applyFilters.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(SeekBar.this,SecondSeekBar.class));
//
//            }
//        });


   // }
//    @Override
//    public void onProgressChanged(android.widget.SeekBar seekBar, int progresValue, boolean fromUser) {
//        int progress = 0;
//        // So here the progress value is saved, sofar the user has moved the filter
//        progress = progresValue;
////                Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
//
//
////                switch (seekBar.getId()){
////                  case R.id.seekBar1:
////                       onStartTrackingTouch(seekBar);
////                       break;
////
////                  case R.id.seekBar2:
////                       onStartTrackingTouch(seekBar);
////                       i=1;
////                       break;
////
////              }
//        if(seekBar.equals(seekBar1)){
//            onStartTrackingTouch(seekBar1);
//            textView1.setText(categories[0] + progress + "/" + seekBar.getMax());
//        }
//        else{
//            onStartTrackingTouch(seekBar2);
//            textView1.setText(categories[1] + progress + "/" + seekBar.getMax());
//        }
//
//
//    }

    // A private method to help us initialize our variables.
//    private void initializeVariables() {
//       seekBar1 =  findViewById(R.id.seekBar1); // initiate the first Seek bar
//        seekBar2 =  findViewById(R.id.seekBar2); // initiate the second Seek bar
//         textView1 = findViewById(R.id.textView1);
//         textView2= findViewById(R.id.textView2);
//    }

//    private void caller(){
//        String sustainabilityCategory[] = {"Vegan: ", "Vegetarian: ", "Recyclable: ", "Regional: ", "Seasonal: ", "Animal Treatment: ", "Co2 Foot Print: ", "Fair Trade: "};
//        String seekBarsList[] = {"seekBar1", "seekBar2", "seekBar3", "seekBar4", "seekBar5", "seekBar6", "seekBar7", "seekBar8", "seekBar9"};
//        String textViewsList[] = {"textView1", "textView2", "textView3", "textView4", "textView5", "textView6", "textView7", "textView8", "textView9"};
//
//    }



//}

