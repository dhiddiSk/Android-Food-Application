package com.example.youcare.utils;

import android.content.Context;
import android.content.SharedPreferences;


public class LocalStorage {

    private static final String sharedName = "YOUCARE_PREFERENCES";
    private SharedPreferences sharedPreferences;
    private static LocalStorage localStorage;

    /***
     * Created Singleton Class for accessing this class methods
     * @param context
     * @return
     */
    public static LocalStorage localStorage(Context context) {
        if (localStorage == null)
            localStorage = new LocalStorage();
        return localStorage;
    }

    // save String Preferences
    public static void saveToLocalStorage(Context mContext, String key, String value) {
        SharedPreferences mySharedPreferences = mContext.getSharedPreferences(sharedName, mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    // load String Preferences
    public static String getLocallyStoredValue(Context mContext, String key) {
        SharedPreferences mySharedPreferences = mContext.getSharedPreferences(sharedName, mContext.MODE_PRIVATE);
        String credential = mySharedPreferences.getString(key, null);
        return credential;
    }

    //Remove String Preference
    public static void removePreferences(Context mContext, String key) {
        SharedPreferences mySharedPreferences = mContext.getSharedPreferences(sharedName, mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }

    public static void clearPreferences(Context mContext) {
        SharedPreferences mySharedPreferences = mContext.getSharedPreferences(sharedName, mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
