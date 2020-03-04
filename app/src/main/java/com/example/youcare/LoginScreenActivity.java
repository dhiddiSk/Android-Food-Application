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

public class LoginScreenActivity extends AppCompatActivity {

            /*
            1) If the person is registering then first accept the data and store it in the sharedPreferenceFile
            2) If the details are pretty similar to the earlier then pop-up a mesasge saying you have already registered
            3) If the person is logging in then, check for the authentication and then allow him to the next page. If the person has entered the wrong details then
            pop up the message saying your credentials are incorrect
            4)
             */



            /*
            @parameter login_Username, login_password are used to store the values only temporarily and is only used for login verification.
            */
            protected   EditText login_Username;
            protected   EditText login_password;

            /*
            @parameters Register_FirstName, Register_LastName, Register_gender_male, Register_gender_female, Register_Email, Register_passWord, ButtonChecked are
            stored inside the shared preference file and are used for the authentication verification purpose.
             */




            public String login_Username_value;
            public String login_password_value;

            public Button loginButton;

            public Button registerClick;
    protected  SharedPreferences dataFiletoStoreCredentials;
    protected  SharedPreferences.Editor credentialsEditor;






            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       /*
       First collect the different user data and store it in the shared preference data storage file.
       Then use it for the verification during the time of user login
       If the user hasn't registered before and tried to login with some random values then there shoud be pop up on the screen
       saying please enter valid details.
        */
//       login_Username = findViewById(R.id.login_username);
//       login_Username_value = login_Username.getText().toString();
//       login_password = findViewById(R.id.login_password);
//       login_password_value = login_password.getText().toString();
//       Register_FirstName = findViewById(R.id.Register_EnterFirstName);
//       Register_FirstName_value = Register_FirstName.getText().toString();
//       Register_LastName = findViewById(R.id.Register_EnterLastName);
//       Register_LastName_value = Register_LastName.getText().toString();
//       Register_Email = findViewById(R.id.Register_EmailAdress);
//       Register_Email_value = Register_Email.getText().toString();
//       Register_passWord = findViewById(R.id.Register_password);
//       Register_passWord_value = Register_passWord.getText().toString();


       loginButton = findViewById(R.id.login_button);
//     final Intent IntentAfterAuthentication = new Intent(LoginScreenActivity.this,ActivityAfterAuthentication.class);
                dataFiletoStoreCredentials = PreferenceManager.getDefaultSharedPreferences(this);

                loginButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               login_Username = findViewById(R.id.login_username);
               login_Username_value = login_Username.getText().toString();
               login_password = findViewById(R.id.login_password);
               login_password_value = login_password.getText().toString();
               if(login_Username_value.isEmpty()||login_password_value.isEmpty()){
                   Toast.makeText(LoginScreenActivity.this, "Enter your Email and Password to login", Toast.LENGTH_SHORT).show();
               }
               else{

                   /*
                   Now verify if the user is real or anonymous by verifying the details from the shared preferences file, if the user is found real then call the next page activity else pop up some other message.
                    */

//
//                   if((dataFiletoStoreCredentials.getString(Register_Email_value,"defaultString").toString()).equals(Register_passWord_value)){
                           if(dataFiletoStoreCredentials.contains(login_Username_value)){
                            /*
                            if the user is found true then pop up a message
                             */
                            startActivity(new Intent(LoginScreenActivity.this, ActivityAfterAuthentication.class));

                   }else{
                            /*
                            if teh user is found false.
                             */
                            Toast.makeText(LoginScreenActivity.this, "Please enter valid credentials", Toast.LENGTH_SHORT).show();
                   }

               }

           }
       });


           registerClick = findViewById(R.id.Register_text);
                registerClick.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {

                                                       startActivity(new Intent(LoginScreenActivity.this, newRegistration.class));


                                                   }
                                               });

//       registration = findViewById(R.id.Register);
//       dataFiletoStoreCredentials = PreferenceManager.getDefaultSharedPreferences(this);
//
//
//
//           registration.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Register_FirstName = findViewById(R.id.Register_EnterFirstName);
//               Register_FirstName_value = Register_FirstName.getText().toString();
//               Register_LastName = findViewById(R.id.Register_EnterLastName);
//               Register_LastName_value = Register_LastName.getText().toString();
//               Register_Email = findViewById(R.id.Register_EmailAdress);
//               Register_Email_value = Register_Email.getText().toString();
//               Register_passWord = findViewById(R.id.Register_password);
//               Register_passWord_value = Register_passWord.getText().toString();
//               if(Register_FirstName_value.isEmpty() || Register_LastName_value.isEmpty() || Register_Email_value.isEmpty() || Register_passWord_value.isEmpty()){
//                  Toast.makeText(LoginScreenActivity.this, "Please enter your details to Register", Toast.LENGTH_SHORT).show();
//               }
//               else{
//
//                   if(dataFiletoStoreCredentials.contains(Register_FirstName_value)||dataFiletoStoreCredentials.contains(Register_LastName_value)||dataFiletoStoreCredentials.contains(Register_Email_value)){
//
//                     /*
//                     Check if the entered details are alredy present, if then show some text saying you are already registered, please check the login
//                      */
//                       Toast.makeText(LoginScreenActivity.this, "User is already Registered, please use your login details to login", Toast.LENGTH_LONG).show();
//                   }
//                   else{
//
//                       /*
//                   Now put the content into the shared preference file, because the user wants to get registered
//                   */
//                       credentialsEditor = dataFiletoStoreCredentials.edit();
//
//                       String RegisterNameKey = "RegisterNameKey"+userCounter;
//                       credentialsEditor.putString(RegisterNameKey, Register_FirstName_value);
//                       String RegisterLastNameKey = "RegisterLastNamekey"+userCounter;
//                       credentialsEditor.putString(RegisterLastNameKey, Register_LastName_value);
//                       String RegisterEmailkey = "RegisterEmailKey"+userCounter;
//                       credentialsEditor.putString(RegisterEmailkey, Register_Email_value);
//                       String RegisterPasswordKey = "RegisterPassword"+userCounter;
//                       credentialsEditor.putString("RegisterPassword", Register_passWord_value);
//                       //The  below put can be used for the validation
//                       credentialsEditor.putString(Register_Email_value, Register_passWord_value);
////                       credentialsEditor.putString("buttonChecked", ButtonChecked);
//                       credentialsEditor.commit();
//                       userCounter = userCounter+1;
//                       Toast.makeText(LoginScreenActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();
//                    /*
//                    Now call the another activity, i.e from the next page.
//                     */
//                       startActivity(new Intent(LoginScreenActivity.this, ActivityAfterAuthentication.class));
//
//
//                   }
//               }
//           }
//       });

    }


//    protected void AfterNewRegistration(){
//        // Now call the next page activity
//            startActivity(IntentAfterAuthentication);
//    }


//    protected void OnClickRadioButton(View view) {
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which RadioButton was clicked
//
//        switch(view.getId()) {
//            case R.id.radioButton_Male:
//                if (checked){
//                    ButtonChecked = "MaleGender";
//                }
//                break;
//            case R.id.radioButton_Female:
//                if (checked){
//                   ButtonChecked = "FemaleGender";
//                }
//                break;
//
//        }
//    }


}
