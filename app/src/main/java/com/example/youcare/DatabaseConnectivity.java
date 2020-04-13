package com.example.youcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.nfc.Tag;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class DatabaseConnectivity extends SQLiteOpenHelper{

        static String name = "database";
        static int version = 2;

        public String firstName = "userFirstName", lastName = "userLastName", pwd = "password", email = "email";

        public String prod = "producer", reg = "regional", logo = "logo";
        String milktable = "milkproduct";
        String usertable = "user";
                // @tables user and milk are to table created to store the content values in the SQLdatabase

    String crateTableMilk = "CREATE TABLE "+milktable+" ( id INTEGER PRIMARY KEY AUTOINCREMENT, "+prod+" TEXT, "+reg+" TEXT, vegan INTEGER, envi INTEGER, animal_welfare INTEGER, health INTEGER, fair_social INTEGER, "+logo+" TEXT)";

    String crateTableUser= "CREATE TABLE "+usertable+" ( id INTEGER PRIMARY KEY AUTOINCREMENT, "+firstName+" TEXT, "+lastName+" TEXT, "+email+" TEXT, "+pwd+" TEXT, MobileNumber INTEGER)";

    public DatabaseConnectivity(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crateTableMilk);
        db.execSQL(crateTableUser);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+usertable);
        db.execSQL("DROP TABLE IF EXISTS "+milktable);
        onCreate(db);

    }


    //@methods insertUser inserts the data into the user database
    public boolean insertvalues(ContentValues contentValues, String tableName) {
           SQLiteDatabase db =this.getWritableDatabase();
           long result = db.insert(tableName, "", contentValues);
           db.close();

           if(result == -1){
               return false;

           }
           return true;
        }



    public boolean isLoginValid(String emailID, String password) {
            String sql = "Select count(*) from user where email='" + emailID + "' and password='" + password + "'";
            SQLiteStatement statement = getReadableDatabase().compileStatement(sql);
            long l = statement.simpleQueryForLong();
            statement.close();

            if (l!=0 ) {
                return true;

            } else {
                return false;
            }


        }


    public String query(boolean regionalUserInput, boolean veganUserInput, int environmentUserRating, int healthUserRating, int fairAndSocialUserRating, int animalTreatmentUserRating){
             String regionaltemp, productOutputAfterQuery = null;

             int temp =2;
             environmentUserRating = temp;


             int vegantemp;

             SQLiteDatabase db = this.getReadableDatabase();


             if(!regionalUserInput){

                regionaltemp = "Germany";

              }
             else{
                regionaltemp = "london";
             }


             if(veganUserInput){
                 vegantemp = 3;
             }
             else {
                 vegantemp = 0;
             }
            // String sqlQuerySearchProduct = "SELECT Producer FROM  milk WHERE Environment " + "=" + 'environmentUserRating';


         //String sqlQuery = "SELECT "+prod+" FROM "+milktable+" WHERE "+env+" =?";
              Cursor cursor = db.rawQuery("SELECT "+prod+" FROM "+milktable+" WHERE envi = ?", new String[]{"2"});



//         Cursor cursor = db.query(milktable, new String[] {prod},
//                 "Environment = ?",
//                 new String[] {"1"},
//                 null,
//                 null,
//                 null);

                    while(cursor.moveToNext()) {
                        int index;

                        index = cursor.getColumnIndexOrThrow("producer");


                        productOutputAfterQuery = cursor.getString(index);
                        cursor.close();
                    }


              //SQLiteStatement stmt = getReadableDatabase().compileStatement(sqlQuerySearchProduct);
              //productOutputAfterQuery = stmt.toString();

               //Cursor cr  =  getWritableDatabase().execSQL(sql);
//            while(cursor.moveToNext()) {
//             int index;
//
//             index = cursor.getColumnIndexOrThrow("Producers");



         return productOutputAfterQuery;

             //... do something with data
         }




     }


