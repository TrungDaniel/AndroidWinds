package com.example.trung.androidwinds.Utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static  String loadJSONFromAsset(Context context) {
        String str = null;
        try {
            InputStream is = context.getAssets().open("home.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            str = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return str;
    }

}
