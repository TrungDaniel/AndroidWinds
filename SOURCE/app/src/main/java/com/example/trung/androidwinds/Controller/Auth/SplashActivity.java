package com.example.trung.androidwinds.Controller.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.example.trung.androidwinds.Utils.AppConfig;
import com.example.trung.androidwinds.Controller.Main.HomeActivity;
import com.example.trung.androidwinds.R;
import com.example.trung.androidwinds.Model.User;

public class SplashActivity extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sceenRouter();
            }
        }, 1000);


    }

    void sceenRouter() {
        String phoneNumber = AppConfig.getPhoneNumber(this);
        if (phoneNumber == null) {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
