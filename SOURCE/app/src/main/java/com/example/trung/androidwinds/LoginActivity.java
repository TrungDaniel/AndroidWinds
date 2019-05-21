package com.example.trung.androidwinds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtPhoneNumber;
    RelativeLayout rlLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();
        dangNhap();

    }

    private void init() {
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        rlLogin = findViewById(R.id.rl_login_button);
        ImageView imgGoogle = findViewById(R.id.img_google_login);
        ImageView imgFacebook = findViewById(R.id.img_facebook_login);


    }

    private void dangNhap() {
        rlLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SoDienThoai = edtPhoneNumber.getText().toString();
                if (checkvalid()) {
                    // tạo user
                    User user = new User();
                    user.setUsername("Trung Daniel");
                    user.setPhoneNumber(SoDienThoai);
                    user.setProfileUrl("https://c.tribune.com.pk/2018/10/1830234-emmadirfani-1540029568.png");
                    //------
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Vui lòng kiểm tra lại số điện thoại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    boolean checkvalid() {
        int phonelength = edtPhoneNumber.getText().toString().length();
        if (phonelength > 9) {
            return true;
        }
        return false;
    }
}
