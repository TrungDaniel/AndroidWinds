package com.example.trung.androidwinds.Controller.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trung.androidwinds.R;
import com.example.trung.androidwinds.Utils.AppConfig;
import com.kofigyan.stateprogressbar.StateProgressBar;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountActivity extends AppCompatActivity {
    Toolbar tbMain;
    TextView soDienThoai, tenNguoiDung;
    CircleImageView ciImageUser;
    LinearLayout lnDangXuat;
    Button btnSuaThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        init();
        getData();
        dangxuat();
        suathongtin();

    }




    private void init() {
        tenNguoiDung = findViewById(R.id.tv_user_name);
        tbMain = findViewById(R.id.tb_main);
        ciImageUser = findViewById(R.id.img_user_url);
        soDienThoai = findViewById(R.id.tv_phone_number);
        btnSuaThongTin = findViewById(R.id.btn_sua_thong_tin);
        LinearLayout lnLichSuGiaoDich = findViewById(R.id.ln_lich_su_giao_dich);
        LinearLayout lnHoiDap = findViewById(R.id.ln_hoi_dap);
        LinearLayout lnHuongDanSuDung = findViewById(R.id.ln_huong_dan_su_dung);
        lnDangXuat = findViewById(R.id.ln_dangxuat);
        toobar();
        // State peogressBar
        String[] descriptionData = {"Thành viên", "Bạc", "Vàng", "Bạch kim"};
        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.your_state_progress_bar_id);
        stateProgressBar.setStateDescriptionData(descriptionData);



    }

    private void getData() {
        String userName = AppConfig.getNameUser(AccountActivity.this);
        String phoneNumber = AppConfig.getPhoneNumber(AccountActivity.this);
        String urlUser = AppConfig.getUrlUser(AccountActivity.this);
        Picasso.get().load(urlUser).placeholder(R.mipmap.img_default_avatar).into(ciImageUser);
        tenNguoiDung.setText(userName);
        soDienThoai.setText(phoneNumber);

    }
    private void suathongtin() {
        btnSuaThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, InfomationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void dangxuat() {
        lnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AccountActivity.this, "dang xuat", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void toobar() {
        setSupportActionBar(tbMain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Tài Khoản");
    }
}
