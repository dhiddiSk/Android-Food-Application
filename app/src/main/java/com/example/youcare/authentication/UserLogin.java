package com.example.youcare.authentication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youcare.database.DatabaseConnectivity;
import com.example.youcare.R;
import com.example.youcare.appbody.MainActivity;
import com.google.android.material.textfield.TextInputLayout;

public class UserLogin extends AppCompatActivity implements View.OnClickListener {

    EditText login_Username, login_password;
    DatabaseConnectivity database;
    public String login_Username_value;
    public String login_password_value;
    public Button loginButton;
    public Button registerClick;
    public Button forgotPassword;
    private TextInputLayout txtip_email;
    private TextInputLayout txtip_password;
    private RelativeLayout rootlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_Username = findViewById(R.id.login_username);
        login_password = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        forgotPassword = findViewById(R.id.forgotPassword);
        forgotPassword.setPaintFlags(forgotPassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtip_email = findViewById(R.id.txtip_email);
        txtip_password = findViewById(R.id.txtip_password);
        rootlayout = findViewById(R.id.rootlayout);
        database = new DatabaseConnectivity(this);

        // on clicks
        findViewById(R.id.id_login).setOnClickListener(this);
        findViewById(R.id.id_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_login:
                String usernameValue = login_Username.getText().toString();
                String passwordValue = login_password.getText().toString();
                if (usernameValue.isEmpty()) {
                    txtip_email.setError("This field is mandatory");
                    txtip_password.setErrorEnabled(false);
                } else if (!isValidEmailAddress(usernameValue)) {
                    txtip_email.setError("Invalid Email");
                    txtip_password.setErrorEnabled(false);
                } else if (passwordValue.isEmpty()) {
                    txtip_email.setErrorEnabled(false);
                    txtip_password.setError("This field is mandatory");
                } else {
                    txtip_email.setErrorEnabled(false);
                    txtip_password.setErrorEnabled(false);
                    txtip_email.clearFocus();
                    txtip_password.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(rootlayout.getWindowToken(), 0);
                    if (database.isLoginValid(usernameValue, passwordValue)) {
                        Toast.makeText(UserLogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UserLogin.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(UserLogin.this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

                case R.id.id_register:
                Intent intent = new Intent(UserLogin.this, UserRegistration.class);
                startActivity(intent);
                break;
        }

    }

    /***
     * Email Validation
     * @param email
     * @return
     */
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}
