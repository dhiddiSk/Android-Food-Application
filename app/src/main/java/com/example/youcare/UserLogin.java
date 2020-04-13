package com.example.youcare;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class UserLogin extends AppCompatActivity {

    EditText login_Username, login_password;
    DatabaseConnectivity database;
    public String login_Username_value;
    public String login_password_value;
    public Button loginButton;
    public Button registerClick;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            login_Username = findViewById(R.id.login_username);
            login_password = findViewById(R.id.login_password);
            loginButton= findViewById(R.id.login_button);
            database = new DatabaseConnectivity(this);


            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String usernameValue = login_Username.getText().toString();
                    String passwordValue = login_password.getText().toString();


                    if (database.isLoginValid(usernameValue, passwordValue)) {
                        Toast.makeText(UserLogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UserLogin.this, EatingPreferences.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(UserLogin.this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
                    }


                }
            });

            registerClick = findViewById(R.id.Register_text);
            registerClick.setPaintFlags(registerClick.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            registerClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(UserLogin.this, UserRegistration.class);
                    startActivity(intent);


                }
            });


        }
    }
