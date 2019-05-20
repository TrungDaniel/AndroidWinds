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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();

    }


    private void init() {
        edtPhoneNumber = (EditText) findViewById(R.id.edt_phone_number);
        RelativeLayout rlLogin = (RelativeLayout) findViewById(R.id.rl_login_button);
        ImageView imgGoogle = (ImageView) findViewById(R.id.img_google_login);
        ImageView imgFacebook = (ImageView) findViewById(R.id.img_facebook_login);

        rlLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SoDienThoai= edtPhoneNumber.getText().toString();
                if (checkvalid()) {
                    User user = new User();
                    user.setUsername("Trung Daniel");
                    user.setPhoneNumber("0387786767");
                    user.setProfileUrl("https://c.tribune.com.pk/2018/10/1830234-emmadirfani-1540029568.png");
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("user",user);
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
