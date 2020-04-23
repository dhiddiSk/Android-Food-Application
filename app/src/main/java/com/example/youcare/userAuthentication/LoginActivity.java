package com.example.youcare.userAuthentication;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.youcare.DatabaseConnectivity;
import com.example.youcare.R;
import com.example.youcare.appBodyNavigation.AppBodyNavigationMainActivity;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private AppCompatEditText login_Username, login_password;
    private TextInputLayout txtip_email,txtip_password;
    DatabaseConnectivity database;
    public String login_Username_value;
    public String login_password_value;
    public Button loginButton;
    public Button registerClick;
    public Button forgotPassword;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            login_Username = findViewById(R.id.login_username);
            login_password = findViewById(R.id.login_password);
            txtip_email = findViewById(R.id.txtip_email);
            txtip_password = findViewById(R.id.txtip_password);
            loginButton= findViewById(R.id.login_button);
            database = new DatabaseConnectivity(this);


            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!TextUtils.isEmpty(login_Username.getText().toString())
                            && !TextUtils.isEmpty(login_password.getText().toString())) {

                        String usernameValue = login_Username.getText().toString();
                        String passwordValue = login_password.getText().toString();

                        if (database.isLoginValid(usernameValue, passwordValue)) {
                            Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, AppBodyNavigationMainActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(LoginActivity.this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "Please give your credentials", Toast.LENGTH_SHORT).show();
                    }


                }
            });
            forgotPassword = findViewById(R.id.forgotPassword);
            forgotPassword.setPaintFlags(forgotPassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


            registerClick = findViewById(R.id.Register_text);
           // registerClick.setPaintFlags(registerClick.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            registerClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, UserRegistration.class);
                    startActivity(intent);


                }
            });


        }
    }
