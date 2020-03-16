package com.example.youcare;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class LoginScreenActivityTwo extends AppCompatActivity {
      EditText login_Username, login_password;
        DatabaseConnectivityTwo database;
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
            database = new DatabaseConnectivityTwo(this);


            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String usernameValue = login_Username.getText().toString();
                    String passwordValue = login_password.getText().toString();


                    if (database.isLoginValid(usernameValue, passwordValue)) {
                        Toast.makeText(LoginScreenActivityTwo.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginScreenActivityTwo.this, eatinghabits.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(LoginScreenActivityTwo.this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
                    }


                }
            });

            registerClick = findViewById(R.id.Register_text);
            registerClick.setPaintFlags(registerClick.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            registerClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginScreenActivityTwo.this, NewRegistrationTwo.class);
                    startActivity(intent);


                }
            });


        }
    }
