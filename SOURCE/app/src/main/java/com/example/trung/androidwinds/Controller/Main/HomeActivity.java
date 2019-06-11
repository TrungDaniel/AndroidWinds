package com.example.trung.androidwinds.Controller.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trung.androidwinds.Controller.Auth.LoginActivity;
import com.example.trung.androidwinds.Controller.Main.Adapter.NewsAdapter;
import com.example.trung.androidwinds.Model.HomeData;
import com.example.trung.androidwinds.R;
import com.example.trung.androidwinds.Utils.AppConfig;
import com.example.trung.androidwinds.Utils.Utils;
import com.google.gson.Gson;

public class HomeActivity extends AppCompatActivity {
    TextView tvUsername, tvPhoneNumber, tvDangXuat;
    ImageView imgCtth1, imgCtth2, imgCtth3;
    TextView tvCtth1, tvCtth2, tvCtth3;
    RecyclerView rvNews;
    HomeData homeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        getData();
        thongTin();
        dangxuat();
        docJson();
        configRvNews();
    }

    private void docJson() {
        String strhomeData = Utils.loadJSONFromAsset(this);
        Gson gson = new Gson();
        homeData = gson.fromJson(strhomeData, HomeData.class);
    }


    private void configRvNews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvNews.setLayoutManager(linearLayoutManager);
        NewsAdapter adapter = new NewsAdapter();
        adapter.setData(homeData.getResult().getListNews());
        adapter.setContext(this);
        rvNews.setAdapter(adapter);
    }


    private void dangxuat() {
        tvDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.logout(HomeActivity.this);
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void thongTin() {
        tvUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AccountActivity.class);
                startActivity(intent);

            }
        });
    }

    private void getData() {
        tvUsername.setText(AppConfig.getNameUser(HomeActivity.this));
        tvPhoneNumber.setText(AppConfig.getPhoneNumber(HomeActivity.this));
    }

    private void init() {
        tvUsername = findViewById(R.id.tv_user_name);
        tvPhoneNumber = findViewById(R.id.tv_phone_number);
        tvDangXuat = findViewById(R.id.tv_dang_xuat);
        rvNews = findViewById(R.id.rv_news);
        imgCtth1 = findViewById(R.id.img_ctth1);
        imgCtth2 = findViewById(R.id.img_ctth2);
        imgCtth3 = findViewById(R.id.img_ctth3);
        tvCtth1 = findViewById(R.id.tv_ctth1);
        tvCtth2 = findViewById(R.id.tv_ctth2);
        tvCtth3 = findViewById(R.id.tv_ctth3);
    }
}
