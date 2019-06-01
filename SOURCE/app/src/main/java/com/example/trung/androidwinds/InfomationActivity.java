package com.example.trung.androidwinds;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class InfomationActivity extends AppCompatActivity {
    Toolbar tbInformation;
    TextView tvNgaySinh;
    EditText edtTen,edtSoDienThoai,edtEmail;
    ImageButton ibNgaySinh;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    Spinner snGioiTinh;
    RelativeLayout rlDongyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomation);
        init();
        setTime();
        setGioiTinh();
        setData();
        sendData();



    }

    private void sendData() {
        rlDongyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtTen.getText().toString();
                String soDienThoai = edtSoDienThoai.getText().toString();
                String ngaySinh = tvNgaySinh.getText().toString();
                String gioiTinh = snGioiTinh.getSelectedItem().toString();
                String email = edtTen.getText().toString();
                AppConfig.setNameUser(ten,InfomationActivity.this);
                AppConfig.setPhoneNumber(soDienThoai,InfomationActivity.this);
                AppConfig.setGioiTinhUser(gioiTinh,InfomationActivity.this);
                AppConfig.setNgaySinhUser(ngaySinh,InfomationActivity.this);
                AppConfig.setEmailUser(email,InfomationActivity.this);

                Toast.makeText(InfomationActivity.this, "Cập nhập thành công", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setData() {
        edtTen.setText(AppConfig.getNameUser(InfomationActivity.this));
        edtSoDienThoai.setText(AppConfig.getPhoneNumber(InfomationActivity.this));
        edtEmail.setText(AppConfig.getEmailUser(InfomationActivity.this));


    }

    private void setGioiTinh() {
        String[] gioitinh = {"Nam","Nữ","LBGT"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,gioitinh);
        snGioiTinh.setAdapter(arrayAdapter);

    }

    private void setTime() {
        ibNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(calendar.YEAR);
                int month = calendar.get(calendar.MONDAY);
                int day = calendar.get(calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(InfomationActivity.this, R.style.Theme_AppCompat_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.show();

            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int thang = month+1;
               tvNgaySinh.setText(dayOfMonth + "/" + thang +"/"+year);
            }
        };
    }


    private void init() {
        tbInformation = (Toolbar) findViewById(R.id.tb_information);
        tvNgaySinh=findViewById(R.id.tv_ngay_sinh);
        edtTen=findViewById(R.id.edt_ten);
        edtSoDienThoai=findViewById(R.id.edt_so_dien_thoai);
        edtEmail=findViewById(R.id.edt_email);
        ibNgaySinh = findViewById(R.id.ib_ngay_sinh);
        snGioiTinh = findViewById(R.id.sn_gioi_tinh);
        rlDongyButton = findViewById(R.id.rl_dongy_button);
        setSupportActionBar(tbInformation);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
}
