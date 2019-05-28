package com.example.trung.androidwinds;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class AppConfig {
    public static final String PREF_NAME="AndroidWinds";


    public static void setPhoneNumber(String phoneNumber, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("PhoneNumber",phoneNumber);
        editor.apply();
    }

    public static String getPhoneNumber(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("PhoneNumber", null);
    }
    public static void logout(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        sharedPreferences.edit().remove("PhoneNumber").commit();
    }
}
