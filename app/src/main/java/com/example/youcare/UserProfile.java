package com.example.youcare;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

import com.example.youcare.userAuthentication.UserRegistration;


public class UserProfile extends AppCompatActivity {
   public int Image_Capture_Code = 1;
   private static final int imageUpload_code = 1;


    public ImageButton imagebutton;
    UserRegistration newRegistrationObject = new UserRegistration();
    public String profileName = newRegistrationObject.UserFullName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_authentication);

//        TextView textView1 = (TextView) findViewById(R.id.userNameOnTopRight);
//
//        textView1.setText(userFullName);

        imagebutton =  findViewById(R.id.userImageView);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //one can use the switch case to access to different views of clicks
                //@cInt can be used to take the picture when the button is pressed

//                Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cInt,Image_Capture_Code);

                // @externalIntent can be used to access the data from the users device storage(External storage)

                Intent exteranlIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(exteranlIntent, imageUpload_code);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==imageUpload_code && requestCode ==RESULT_OK && data !=null){

            Uri Selectedimagedata = data.getData();
            imagebutton.setImageURI(Selectedimagedata);
        }
    }

}