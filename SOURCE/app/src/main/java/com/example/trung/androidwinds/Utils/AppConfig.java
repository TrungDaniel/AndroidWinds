package com.example.trung.androidwinds.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConfig {
    public static final String PREF_NAME = "AndroidWinds";


    public static void setPhoneNumber(String phoneNumber, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("PhoneNumber", phoneNumber);
        editor.apply();
    }

    public static void setNameUser(String nameUser, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NameUser", nameUser);
        editor.apply();
    }


    public static void setUrlUser(String urlUser, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UrlUser", urlUser);
        editor.apply();
    }

    public static void setNgaySinhUser(String ngaySinh, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NgaySinh", ngaySinh);
        editor.apply();
    }
    public static int setGioiTinhUser(int gioiTinh, Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("GioiTinh",gioiTinh);
        editor.apply();
        return gioiTinh;
    }
    public static void setEmailUser(String email, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email", email);
        editor.apply();
    }

    // ------------------------------------------------

    public static String getPhoneNumber(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("PhoneNumber", null);
    }

    public static String getNameUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("NameUser", null);
    }

    public static String getUrlUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("UrlUser", null);
    }
    public static String getNgaySinhUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("NgaySinh", "1/1/1900");
    }
    public static String getEmailUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Email", "@gmai.com");
    }
    public static int getGioiTinh(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("GioiTinh",2);
    }





    public static void logout(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove("PhoneNumber").commit();
    }
}
