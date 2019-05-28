package com.example.trung.androidwinds;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

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
            User user = new User();
            user.setUsername("Trung Daniel");
            user.setPhoneNumber("0387786767");
            user.setProfileUrl("https://c.tribune.com.pk/2018/10/1830234-emmadirfani-1540029568.png");
            startActivity(intent);
            finish();
        }

    }
}
