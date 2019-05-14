package com.example.trung.androidwinds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        // tao doi tuong user
        User windsUser = new User();
        windsUser.setId(1);
        windsUser.setPhoneNumber("0387786767");
        windsUser.setProfileUrl("http://pornhub.com/avatar.ipg");
        windsUser.setUsername("Trung");

        final EditText edtPhoneNumber = findViewById(R.id.edt_phone_number);
        TextView tvDangNhap = findViewById(R.id.tv_dang_nhap);
        //Toast.makeText(this, ""+windsUser.getUsername(), Toast.LENGTH_LONG).show();
        // sử dụng đối tượng được khai báo và khởi tạo trong file xml
        /*
            bước 1 : gán id cho đối tượng trong xml
            bước 2 : tạo tên mới và gán lại cho đối tượng ;

         */
        // function click textview dang nhap
        tvDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtPhoneNumber.length()==0){
                    edtPhoneNumber.setHint("!");
                    edtPhoneNumber.setHintTextColor(getResources().getColor(R.color.colorRed));
                }
                else {
                    Toast.makeText(MainActivity.this, "bla bla", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }


}
