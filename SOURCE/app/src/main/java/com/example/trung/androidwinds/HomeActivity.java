package com.example.trung.androidwinds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView tvUsername, tvPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        getData();
    }

    private void getData() {
        User user = (User) getIntent().getSerializableExtra("user");
        tvUsername.setText(user.getUsername());
        tvPhoneNumber.setText(user.getPhoneNumber());
    }

    private void init() {
        tvUsername = findViewById(R.id.tv_user_name);
        tvPhoneNumber = findViewById(R.id.tv_phone_number);
    }
}
