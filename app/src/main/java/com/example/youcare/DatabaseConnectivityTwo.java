package com.example.youcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;
public class DatabaseConnectivityTwo extends SQLiteOpenHelper {

        static String name = "database";
        static int version = 1;

        String createTableUser = "CREATE TABLE if not exists `user` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `userFirstName` TEXT, `userLastName` TEXT," +
                " `email` TEXT, `password` TEXT, `MobileNumber` INTEGER )";


        public DatabaseConnectivityTwo(Context context) {
            super(context, name, null, version);
            getWritableDatabase().execSQL(createTableUser);
        }

        public void insertUser(ContentValues contentValues) {
            getWritableDatabase().insert("user", "", contentValues);
        }

        public boolean isLoginValid(String emailID, String password) {
            String sql = "Select count(*) from user where email='" + emailID + "' and password='" + password + "'";
            SQLiteStatement statement = getReadableDatabase().compileStatement(sql);
            long l = statement.simpleQueryForLong();
            statement.close();

            if (l == 1) {
                return true;

            } else {
                return false;
            }


        }


        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
