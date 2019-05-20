package com.example.trung.androidwinds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kofigyan.stateprogressbar.StateProgressBar;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Toolbar tbMain;
    TextView soDienThoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getData();


    }

    private void getData() {
        //String phoneNumber = getIntent().getStringExtra("information");
        User user =(User) getIntent().getSerializableExtra("user");

        soDienThoai.setText(user.getPhoneNumber());


    }

    private void init() {
        tbMain = findViewById(R.id.tb_main);
        soDienThoai = findViewById(R.id.tv_phone_number);
        Button btnSuaThongTin = findViewById(R.id.btn_sua_thong_tin);
        LinearLayout lnLichSuGiaoDich = findViewById(R.id.ln_lich_su_giao_dich);
        LinearLayout lnHoiDap = findViewById(R.id.ln_hoi_dap);
        LinearLayout lnHuongDanSuDung = findViewById(R.id.ln_huong_dan_su_dung);
        LinearLayout lnDangXuat = findViewById(R.id.ln_dangxuat);
        lnLichSuGiaoDich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Chức năng sẽ cập nhập sau", Toast.LENGTH_SHORT).show();
            }
        });
        lnHoiDap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Chức năng sẽ cập nhập sau", Toast.LENGTH_SHORT).show();
            }
        });
        lnHuongDanSuDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Chức năng sẽ cập nhập sau", Toast.LENGTH_SHORT).show();
            }
        });
        lnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDangXuat = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intentDangXuat);
            }
        });


        btnSuaThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Chức năng sẽ cập nhập sau", Toast.LENGTH_SHORT).show();
            }
        });


        String[] descriptionData = {"Thành viên", "Bạc", "Vàng", "Bạch kim"};
        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.your_state_progress_bar_id);

        stateProgressBar.setStateDescriptionData(descriptionData);
        toobar();

    }

    private void toobar() {
        setSupportActionBar(tbMain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Tài Khoản");
    }
}
