package com.example.youcare;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewRegistrationTwo extends AppCompatActivity {
    DatabaseConnectivityTwo database;
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
            database = new DatabaseConnectivityTwo(this);


            registration.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String usernamefirstname = Register_FirstName.getText().toString();
                    String userlastname = Register_LastName.getText().toString();
                    String UserFullName = usernamefirstname+userlastname;
                    String passwordValue = Register_passWord.getText().toString();
                    String emailValue = Register_Email.getText().toString();
                    int Reigister_mobile_value = mobileNumber;

                    if (UserFullName.length() > 1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("userFirstName",usernamefirstname);
                        contentValues.put("userLastName", userlastname);
                        contentValues.put("email", emailValue);
                        contentValues.put("password", passwordValue);
                        contentValues.put("MobileNumber", Reigister_mobile_value);

                        database.insertUser(contentValues);
                        Toast.makeText(NewRegistrationTwo.this, "User registered!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(NewRegistrationTwo.this,LoginScreenActivityTwo.class));


                    }
                    else {
                        Toast.makeText(NewRegistrationTwo.this, "Enter the values!", Toast.LENGTH_SHORT).show();
                    }


                }
            });


        }
    }
