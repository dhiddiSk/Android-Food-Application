//package com.example.youcare;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.database.sqlite.SQLiteStatement;
//
//import androidx.annotation.Nullable;
//
///*
//This dataBase is created to insert the values of the user during their logins nad registering and also can be further used
//to carry any computation regarding the customer journey etc.
// */
//
//
//
//public class Databaseconnectivity extends SQLiteOpenHelper {
//
//    // @DatabaseName is the name of database
//    private static  String DatabaseName = "food.db";
//    //@Database version is the version of the database
//     private static int dbversion =1;
//    //@tableName is the name of the table
//     private static String tableName = "userDetails";
//
//    // defining the names of the columns in database
//     private static String userFirstName = "UserFirstName";
//     private static String userLastName = "UserLastName";
//     private static  String userEmailId = "EmailId";
//     private static String userPhoneNumber = "UserPhoneNumber";
//     private static String gender = "UserGender";
//     private static String password = "UserPassword";
//
//    // id of the each row
//     private static String key_Id = "id";
//
//     public Databaseconnectivity(Context context) {
//        super(context, DatabaseName, null, dbversion);
//    }
//
//    //      public Databaseconnectivity(Context context) {
////        super(context, DatabaseName, null, dbversion);
////    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db = this.getWritableDatabase();
//         String create_table = "CREATE TABLE " + tableName +"("+ key_Id +" INTEGER PRIMARY KEY AUTOINCREMENT," + userFirstName + " TEXT,"+ userLastName +
//                    " TEXT," + userPhoneNumber + " INTEGER," + gender + "TEXT," + userEmailId +" TEXT,"+ password + " TEXT" +")";
//            db.execSQL(create_table);
//                  //  "CREATE TABLE "+ tableName + " (key_Id INTEGER PRIMARY KEY AUTOINCREMENT, userFirstName TEXT, userLastName TEXT, userPhoneNumber INTEGER, gender TEXT, userEmailId TEXT, password TEXT)");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//         String dropTable = "DROP TABLE IF EXISTS " + tableName;
//         db.execSQL(dropTable);
//         onCreate(db);
//
//    }
//
//    public void insertDataToDb(ContentValues contentValues){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//       // long key_Id =
//                db.insert(tableName,"",contentValues);
////        if(key_Id==-1) return true;
////        else return false;
//    }
//
//    public boolean verifyLogin(String emailId, String UserPassword){
//       /*
//       Now verify in the database first if the emailId exists, if exists then check for the password and return true if it matches
//       else false.
//        */
//       SQLiteDatabase db = this.getReadableDatabase();
//       String query = "Select count(*) from userDetails where userEmailId='" + emailId + "' and password='" +UserPassword+"'";
//        SQLiteStatement  statement = db.compileStatement(query);
//        Long l = statement.simpleQueryForLong();
//        statement.close();
//        if(l==1) return true;
//        else return false;
//
//    }
//
//    public boolean verifyOnlyEmail(String emailId){
//
//        SQLiteDatabase db = this.getReadableDatabase();
//       // String query = "SELECT 'userEmailId' FROM 'userDetails' WHERE column LIKE 'emailId'";
//        Cursor res = db.rawQuery("SELECT * FROM userDetails WHERE userEmailId=?", new String[]{emailId});
//        res.close();
//        if(res.getCount()>0) return false;
//        else return true;
//
//    }
//}