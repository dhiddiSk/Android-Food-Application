package com.example.youcare.authentication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youcare.database.DatabaseConnectivity;
import com.example.youcare.R;
import com.example.youcare.appbody.MainActivity;
import com.example.youcare.utils.LocalStorage;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

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
        // Retriving from session
        if ((LocalStorage.getLocallyStoredValue(this,"username") != null )&& !(LocalStorage.getLocallyStoredValue(this,"username").isEmpty())
        && (LocalStorage.getLocallyStoredValue(this,"password") != null )&& !(LocalStorage.getLocallyStoredValue(this,"password").isEmpty())){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

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
        forgotPassword.setOnClickListener(this);

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

                        //save credentials to local storage for maintaining user login session
                        LocalStorage.saveToLocalStorage(this,"username",usernameValue);
                        LocalStorage.saveToLocalStorage(this,"password",passwordValue);

                        Toast.makeText(LoginActivity.this, "Welcome to "+getResources().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.id_register:
                Intent intent = new Intent(LoginActivity.this, UserRegistration.class);
                startActivity(intent);
                break;

            case R.id.forgotPassword:
                showPasswordDialog(v.getContext());
        }

    }

    private void showPasswordDialog(Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_forgotpassword);
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextInputLayout txtip_forgotPasssword = dialog.findViewById(R.id.txtip_forgotpasssword);
        final EditText et_forgotPassword = dialog.findViewById(R.id.et_forgotpassword);
        final TextInputLayout txtip_newPassword = dialog.findViewById(R.id.txtip_newpassword);
        final EditText et_newPassword = dialog.findViewById(R.id.et_newpassword);

        LinearLayout send_forgotPasssword = dialog.findViewById(R.id.id_forgotpassword);
        send_forgotPasssword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_forgotPassword.getText() != null && et_forgotPassword.getText().toString() != null
                        && !et_forgotPassword.getText().toString().isEmpty()){
                    txtip_forgotPasssword.setErrorEnabled(false);
                    if (!isValidEmailAddress(et_forgotPassword.getText().toString().trim())) {
                        txtip_forgotPasssword.setError("Invalid Email");
                    }else if (!database.checkEmailExists(et_forgotPassword.getText().toString().trim())){
                        txtip_forgotPasssword.setError("Email not registered");
                    } else {
                        // Making New Password Validation Here
                        if (et_newPassword.getText()!= null && et_newPassword.getText().toString() != null
                                && !et_newPassword.getText().toString().trim().isEmpty()){

                            txtip_forgotPasssword.setErrorEnabled(false);
                            txtip_newPassword.setErrorEnabled(false);
                            txtip_forgotPasssword.clearFocus();
                            txtip_newPassword.clearFocus();
                            LocalStorage.clearPreferences(context); //clearing preferences
                            // Updating Record with New Password
                            database.update(et_newPassword.getText().toString().trim(),et_forgotPassword.getText().toString().trim());
                            if (dialog != null && dialog.isShowing()) dialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Password Updated, Please Login with New Password Now", Toast.LENGTH_SHORT).show();
                        }else{
                            txtip_newPassword.setError("Invalid New Password");
                        }
                    }
                }else{
                    txtip_forgotPasssword.setError("This field is mandatory");
                }
            }
        });

        dialog.show();
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
