package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import com.example.youcare.databaseconnectivity;

public class newRegistration extends AppCompatActivity {

    /*
             @parameter dataFiletoStoreCredentials is used to store the login details of the people in a file and not in any database
             @prarmeter credentialsEditor is used to perform actions on the data
     */
    protected   EditText Register_FirstName;
    protected   EditText Register_LastName;
    protected   RadioButton Register_gender_male;
    protected   RadioButton Register_gender_female;
    protected   EditText Register_Email;
    protected   EditText Register_passWord;
    protected   int mobileNumber;
    public String Register_FirstName_value;
    public String Register_LastName_value;
    public String Register_Email_value;
    public String Register_passWord_value;
    public int Reigister_mobile_value;
    public Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_registration);
        registration = findViewById(R.id.Register);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /*
               Once onclicked then pass the values to the DB through some method calling and then insert the values into the DB.
               When you need for the verification then call a method which can chek the values with some queries.
               And also use some method which can send some boolean value for the authentication.

               */
                Register_FirstName = findViewById(R.id.Register_EnterFirstName);
                Register_FirstName_value = Register_FirstName.getText().toString();
                Register_LastName = findViewById(R.id.Register_EnterLastName);
                Register_LastName_value = Register_LastName.getText().toString();
                Register_Email = findViewById(R.id.Register_EmailAdress);
                Register_Email_value = Register_Email.getText().toString();
                mobileNumber = (R.id.phone_number);
                Reigister_mobile_value = mobileNumber;
                Register_passWord = findViewById(R.id.Register_password);
                Register_passWord_value = Register_passWord.getText().toString();
                if(Register_FirstName_value.isEmpty() || Register_LastName_value.isEmpty() || Register_Email_value.isEmpty() || Register_passWord_value.isEmpty() || Reigister_mobile_value < 0){
                    Toast.makeText(newRegistration.this, "Please enter your complete details to Register", Toast.LENGTH_LONG).show();
                }
                else{

                    databaseconnectivity databaseObject = new databaseconnectivity(null, "fooddb",null,1);
                    boolean verifyIfUserAlreadyExists;
                    verifyIfUserAlreadyExists = databaseObject.verifyOnlyEmail(Register_Email_value);

                    if(verifyIfUserAlreadyExists){

                     /*
                     Check if the entered details are alredy present, if then show some text saying you are already registered, please check the login
                      */
                        Toast.makeText(newRegistration.this, "User is already Registered, please use your login details to login", Toast.LENGTH_LONG).show();
                    }
                    else{

                       /*
                   Now put the content into the shared preference file, because the user wants to get registered
                   */
                        databaseObject.insertDataToDb(Register_FirstName_value, Register_LastName_value, Reigister_mobile_value, Register_Email_value, Register_passWord_value);
                        Toast.makeText(newRegistration.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                    /*startActivity
                    Now call the another activity, i.e from the next page.
                     */
                        startActivity(new Intent(newRegistration.this, ActivityAfterAuthentication.class));


                    }
                }
            }
        });
    }
}
