package com.example.trung.androidwinds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView tvUsername, tvPhoneNumber,tvDangXuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        dangxuat();
        sendData();
     //   getData();
    }

    private void dangxuat() {
        tvDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.logout(HomeActivity.this);
                Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void sendData() {
        tvUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AccountActivity.class);
                User user = new User();
                user.setUsername("Trung Daniel");
                user.setPhoneNumber(tvPhoneNumber.getText().toString());
                user.setProfileUrl("https://c.tribune.com.pk/2018/10/1830234-emmadirfani-1540029568.png");
                intent.putExtra("user", user);
                startActivity(intent);

            }
        });
    }

    private void getData() {
        User user = (User) getIntent().getSerializableExtra("user");
        tvUsername.setText(user.getUsername());
        tvPhoneNumber.setText(user.getPhoneNumber());
    }

    private void init() {
        tvUsername = findViewById(R.id.tv_user_name);
        tvPhoneNumber = findViewById(R.id.tv_phone_number);
        tvDangXuat=findViewById(R.id.tv_dang_xuat);
    }
}
