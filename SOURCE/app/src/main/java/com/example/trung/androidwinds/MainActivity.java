package com.example.trung.androidwinds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
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

        //Toast.makeText(this, ""+windsUser.getUsername(), Toast.LENGTH_LONG).show();
        // sử dụng đối tượng được khai báo và khởi tạo trong file xml
        /*
            bước 1 : gán id cho đối tượng trong xml
            bước 2 : tạo tên mới và gán lại cho đối tượng ;

         */
        EditText edtPhoneNumber = findViewById(R.id.edt_phone_number);
        edtPhoneNumber.setText("0387786767");

    }
}
