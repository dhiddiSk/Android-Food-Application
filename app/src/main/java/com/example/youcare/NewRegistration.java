//package com.example.youcare;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.ContentValues;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.Toast;
//
//public class NewRegistration extends AppCompatActivity {
//
//    Databaseconnectivity newDbObj;
//    /*
//             @parameter dataFiletoStoreCredentials is used to store the login details of the people in a file and not in any database
//             @prarmeter credentialsEditor is used to perform actions on the data
//     */
//    protected  EditText Register_FirstName;
//    protected  EditText Register_LastName;
//    protected  RadioButton Register_gender_male;
//    protected  RadioButton Register_gender_female;
//    protected  EditText Register_Email;
//    protected  EditText Register_passWord;
//    protected  int mobileNumber;
//    public String Register_FirstName_value;
//    public String Register_LastName_value;
//    public String Register_Email_value;
//    public String Register_passWord_value;
//    public int Reigister_mobile_value;
//    public Button registration;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_new_registration);
//
//        Register_FirstName = findViewById(R.id.Register_EnterFirstName);
//        Register_LastName = findViewById(R.id.Register_EnterLastName);
//        Register_Email = findViewById(R.id.Register_EmailAdress);
//        mobileNumber = (R.id.phone_number);
//        Register_passWord = findViewById(R.id.Register_password);
//        registration = findViewById(R.id.Register);
//        newDbObj = new Databaseconnectivity(this);
//        registration.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Register_FirstName_value = Register_FirstName.getText().toString();
//                Register_LastName_value = Register_LastName.getText().toString();
//                Register_Email_value = Register_Email.getText().toString();
//                Reigister_mobile_value = mobileNumber;
//                Register_passWord_value = Register_passWord.getText().toString();
//
//
//               /*
//               Once onclicked then pass the values to the DB through some method calling and then insert the values into the DB.
//               When you need for the verification then call a method which can chek the values with some queries.
//               And also use some method which can send some boolean value for the authentication.
//
//               */
//
//
//                if(Register_FirstName_value.isEmpty() || Register_LastName_value.isEmpty() || Register_Email_value.isEmpty() || Register_passWord_value.isEmpty() || Reigister_mobile_value < 0){
//                    Toast.makeText(NewRegistration.this, "Please enter your complete valid details to Register", Toast.LENGTH_LONG).show();
//                }
//                else{
//
//
//                    boolean verifyIfUserAlreadyExists;
//                    verifyIfUserAlreadyExists = newDbObj.verifyOnlyEmail(Register_Email_value);
//
//                    if(verifyIfUserAlreadyExists){
//
//                     /*
//                     Check if the entered details are alredy present, if then show some text saying you are already registered, please check the login
//                      */
//                        Toast.makeText(NewRegistration.this, "You are already registered, please use your login details to login", Toast.LENGTH_LONG).show();
//                    }
//                    else{
//
//                      boolean insertionTemp;
//                       /*
//                   Now put the content into the shared preference file, because the user wants to get registered
//                   */
//                        ContentValues contentValues = new ContentValues();
//                        contentValues.put("userFirstName", Register_FirstName_value);
//                        contentValues.put("userLastName", Register_LastName_value);
//                        contentValues.put("userPhoneNumber", Reigister_mobile_value);
//                        contentValues.put("userEmailId", Register_Email_value);
//                        contentValues.put("password", Register_passWord_value);
//                        newDbObj.insertDataToDb(contentValues);
//
//
//                      // newDbObj.insertDataToDb(Register_FirstName_value, Register_LastName_value, Reigister_mobile_value, Register_Email_value, Register_passWord_value);
//
//                       //if(insertionTemp)
//                           Toast.makeText(NewRegistration.this, "Successfully Registered", Toast.LENGTH_LONG).show();
//                       //else  Toast.makeText(NewRegistration.this, "Not Successfully Registered", Toast.LENGTH_LONG).show();
//
//
//
//                     /*startActivity
//                    Now call the another activity, i.e from the next page.
//                     */
//                //startActivity(new Intent(NewRegistration.this, ActivityAfterAuthentication.class));
//                startActivity(new Intent(NewRegistration.this, eatinghabits.class));
//                    }
//                }
//            }
//        });
//    }
//
//}
