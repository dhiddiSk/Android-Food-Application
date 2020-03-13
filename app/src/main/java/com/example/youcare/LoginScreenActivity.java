package com.example.youcare;

import androidx.appcompat.app.AppCompatActivity;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);
                loginButton = findViewById(R.id.login_button);
                loginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        login_Username = findViewById(R.id.login_username);
                        login_Username_value = login_Username.getText().toString();
                        login_password = findViewById(R.id.login_password);
                        login_password_value = login_password.getText().toString();

//                        Databaseconnectivity databaseconnectivityObject = new Databaseconnectivity(null, "fooddb", null, 1);
//
//
//                        if (login_Username_value.isEmpty() || login_password_value.isEmpty()) {
//                            Toast.makeText(LoginScreenActivity.this, "Enter your Email and Password to login", Toast.LENGTH_SHORT).show();
//                        } else {
//
//                   /*
//                   Now verify if the user is real or anonymous by verifying the details from the shared preferences file, if the user is found real then call the next page activity else pop up some other message.
//                    */
//
//                            boolean validUser;
//                            validUser = databaseconnectivityObject.verifyTheUser(login_Username_value, login_password_value);
//                            if (validUser) {
//                            /*
//                            if the user is found true then pop up a message
//                             */
                                startActivity(new Intent(LoginScreenActivity.this, ActivityAfterAuthentication.class));
//
//                            } else {
//                            /*
//                            if teh user is found false.
//                             */
//                                Toast.makeText(LoginScreenActivity.this, "Please enter valid credentials", Toast.LENGTH_SHORT).show();
                            }

                        });

//                    }
//                });


                registerClick = findViewById(R.id.Register_text);
                registerClick.setPaintFlags(registerClick.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                registerClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(LoginScreenActivity.this, NewRegistration.class));


                    }
                });
            }

}
