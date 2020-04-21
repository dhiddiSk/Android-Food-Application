package com.example.youcare.userAuthentication;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youcare.DatabaseConnectivity;
import com.example.youcare.R;

public class UserRegistration extends AppCompatActivity {
    DatabaseConnectivity database;
    protected  EditText Register_FirstName;
    protected  EditText Register_LastName;
    protected  RadioButton Register_gender_male;
    protected  RadioButton Register_gender_female;
    protected  EditText Register_Email;
    protected  EditText Register_passWord;
    protected  int mobileNumber;
    public String Register_FirstName_value;
    public String Register_LastName_value;
    public String Register_Email_value;
    public String Register_passWord_value;
    public String UserFullName;
    //public int Reigister_mobile_value;
    public Button registration;

    String usertable = "user";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_new_registration);
            Register_FirstName = findViewById(R.id.Register_EnterFirstName);
            Register_LastName = findViewById(R.id.Register_EnterLastName);
            Register_passWord = findViewById(R.id.Register_password);
            Register_Email = findViewById(R.id.Register_EmailAddress);
            registration = findViewById(R.id.Register);
            mobileNumber = R.id.phone_number;
            database = new DatabaseConnectivity(this);


            registration.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String usernamefirstname = Register_FirstName.getText().toString();
                    String userlastname = Register_LastName.getText().toString();
                    String UserFullName = usernamefirstname+userlastname;
                    String passwordValue = Register_passWord.getText().toString();
                    String emailValue = Register_Email.getText().toString();
                    int Reigister_mobile_value = mobileNumber;

                    if (UserFullName.length() > 1 && userlastname.length() >1 && passwordValue.length() >1 && emailValue.length() > 1 && Reigister_mobile_value>99999) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("userFirstName",usernamefirstname);
                        contentValues.put("userLastName", userlastname);
                        contentValues.put("email", emailValue);
                        contentValues.put("password", passwordValue);
                        contentValues.put("MobileNumber", Reigister_mobile_value);

                       boolean insertdescision = database.insertvalues(contentValues,usertable);
                          if(insertdescision){
                              Toast.makeText(UserRegistration.this, "User registered!", Toast.LENGTH_SHORT).show();
                              startActivity(new Intent(UserRegistration.this, UserLogin.class));

                          }

                          else {
                              Toast.makeText(UserRegistration.this, "User registration failed", Toast.LENGTH_SHORT).show();

                          }
                    }
                    else {
                        Toast.makeText(UserRegistration.this, "Please complete the details!", Toast.LENGTH_SHORT).show();
                    }


                }
            });


        }
    }
