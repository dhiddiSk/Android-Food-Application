package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class newRegistration extends AppCompatActivity {

    /*
             @parameter dataFiletoStoreCredentials is used to store the login details of the people in a file and not in any database
             @prarmeter credentialsEditor is used to perform actions on the data
     */
    protected  SharedPreferences dataFiletoStoreCredentials;
    protected  SharedPreferences.Editor credentialsEditor;

    protected   EditText Register_FirstName;
    protected   EditText Register_LastName;
    protected   RadioButton Register_gender_male;
    protected   RadioButton Register_gender_female;
    protected   EditText Register_Email;
    protected   EditText Register_passWord;
    protected   String ButtonChecked = "";


    public String login_Username_value;
    public String login_password_value;
    public String Register_FirstName_value;
    public String Register_LastName_value;
    public String Register_Email_value;
    public String Register_passWord_value;

    public Button loginButton;

    public Button registration;

    public int userCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_registration);
        registration = findViewById(R.id.Register);
        dataFiletoStoreCredentials = PreferenceManager.getDefaultSharedPreferences(this);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register_FirstName = findViewById(R.id.Register_EnterFirstName);
                Register_FirstName_value = Register_FirstName.getText().toString();
                Register_LastName = findViewById(R.id.Register_EnterLastName);
                Register_LastName_value = Register_LastName.getText().toString();
                Register_Email = findViewById(R.id.Register_EmailAdress);
                Register_Email_value = Register_Email.getText().toString();
                Register_passWord = findViewById(R.id.Register_password);
                Register_passWord_value = Register_passWord.getText().toString();
                if(Register_FirstName_value.isEmpty() || Register_LastName_value.isEmpty() || Register_Email_value.isEmpty() || Register_passWord_value.isEmpty()){
                    Toast.makeText(newRegistration.this, "Please enter your details to Register", Toast.LENGTH_SHORT).show();
                }
                else{

                    if(dataFiletoStoreCredentials.contains(Register_FirstName_value)||dataFiletoStoreCredentials.contains(Register_LastName_value)||dataFiletoStoreCredentials.contains(Register_Email_value)){

                     /*
                     Check if the entered details are alredy present, if then show some text saying you are already registered, please check the login
                      */
                        Toast.makeText(newRegistration.this, "User is already Registered, please use your login details to login", Toast.LENGTH_LONG).show();
                    }
                    else{

                       /*
                   Now put the content into the shared preference file, because the user wants to get registered
                   */
                        credentialsEditor = dataFiletoStoreCredentials.edit();

                        String RegisterNameKey = "RegisterNameKey"+userCounter;
                        credentialsEditor.putString(RegisterNameKey, Register_FirstName_value);
                        String RegisterLastNameKey = "RegisterLastNamekey"+userCounter;
                        credentialsEditor.putString(RegisterLastNameKey, Register_LastName_value);
                        String RegisterEmailkey = "RegisterEmailKey"+userCounter;
                        credentialsEditor.putString(RegisterEmailkey, Register_Email_value);
                        String RegisterPasswordKey = "RegisterPassword"+userCounter;
                        credentialsEditor.putString("RegisterPassword", Register_passWord_value);
                        //The  below put can be used for the validation
                        credentialsEditor.putString(Register_Email_value, Register_passWord_value);
//                       credentialsEditor.putString("buttonChecked", ButtonChecked);
                        credentialsEditor.commit();
                        userCounter = userCounter+1;
                        Toast.makeText(newRegistration.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                    /*
                    Now call the another activity, i.e from the next page.
                     */
                        startActivity(new Intent(newRegistration.this, ActivityAfterAuthentication.class));


                    }
                }
            }
        });
    }
}
