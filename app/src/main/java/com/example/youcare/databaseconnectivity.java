package com.example.youcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/*
This dataBase is created to insert the values of the user during their logins nad registering and also can be further used
to carry any computation regarding the customer journey etc.
 */



public class databaseconnectivity extends SQLiteOpenHelper {
     private static  String DatabaseName = "fooddb";
      private static String tableName = "userDetails";
      private static int dbversion =1;
      private static String userFirstName = "UserFirstName";
      private static String userLastName = "UserLastName";
      private static String key_Id = "id";
      private static  String userEmailId = "EmailId";
      private static String userPhoneNumber = "UserPhoneNumber";
      private static String gender = "UserGender";
      private static String password = "UserPassword";

    public databaseconnectivity(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DatabaseName, factory, dbversion);
    }

    //      public databaseconnectivity(Context context) {
//        super(context, DatabaseName, null, dbversion);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String create_table = "CREATE TABLE " + tableName +"("+ key_Id +" INTEGER PRIMARY KEY AUTOINCREMENT," + userFirstName + " TEXT,"+ userLastName +
                    " TEXT," + userPhoneNumber + " INTEGER," + gender + "TEXT," + userEmailId +" TEXT,"+ password + " TEXT" +")";
            db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         String dropTable = "DROP TABLE IF EXISTS " + tableName;
         db.execSQL(dropTable);
         onCreate(db);
    }

    public void insertDataToDb(String firstName, String lastName, Integer phoneNumber, String emailId, String userpassword){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(userFirstName, firstName);
        contentValues.put(userLastName, lastName);
        contentValues.put(userPhoneNumber, phoneNumber);
        contentValues.put(userEmailId, emailId);
        contentValues.put(password, userpassword);
        long newRowId = db.insert(tableName,null,contentValues);
        db.close();

    }

    public boolean verifyTheUser(String emailId, String UserPassword){
       /*
       Now verify in the database first if the emailId exists, if exists then check for the password and return true if it matches
       else false.
        */
       SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT userEmailId FROM userDetails WHERE password = "+ UserPassword,null);
        String temp = res.toString();
        res.close();
        if(temp.equals(emailId)){
            return true;
        }
        return false;

    }
//    public boolean verifyOnlyEmail(String emailId){
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res = db.rawQuery(SELECT * FROM userDetails WHERE CONTAINS(userEmailId, emailId),null);
//        String temp = res.toString();
//        res.close();
//        if (temp.equals(emailId)){
//            return true;
//        }
//        else
//            return false;

//    }






}