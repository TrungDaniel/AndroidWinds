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
    String soDienThoai;

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
                soDienThoai = edtPhoneNumber.getText().toString();
                if (checkvalid()) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    setProfile();
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Vui lòng kiểm tra lại số điện thoại", Toast.LENGTH_SHORT).show();
                }
            }

            private void setProfile() {
                AppConfig.setPhoneNumber(soDienThoai, LoginActivity.this);
                AppConfig.setNameUser("Trung Daniel",LoginActivity.this);
                AppConfig.setUrlUser("https://bitly.vn/46l9",LoginActivity.this);

            }
        });
    }

    boolean checkvalid() {
        int phonelength = edtPhoneNumber.getText().toString().length();
        if (phonelength == 10 ) {
            return true;
        }
        return false;
    }


}
