package com.example.trung.androidwinds.Controller.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.trung.androidwinds.Controller.Auth.LoginActivity;
import com.example.trung.androidwinds.Controller.Main.Adapter.NewsAdapter;
import com.example.trung.androidwinds.Controller.Main.Adapter.PromotionAdapter;
import com.example.trung.androidwinds.Model.HomeData;
import com.example.trung.androidwinds.R;
import com.example.trung.androidwinds.Utils.AppConfig;
import com.example.trung.androidwinds.Utils.Utils;
import com.google.gson.Gson;

public class HomeActivity extends AppCompatActivity {
    TextView tvUsername, tvPhoneNumber, tvDangXuat;
    RecyclerView rvNews, rvPromotion;
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
        configRvPromotion();
    }

    private void docJson() {
        String strhomeData = Utils.loadJSONFromAsset(this);
        Gson gson = new Gson();
        homeData = gson.fromJson(strhomeData, HomeData.class);
    }

    private void configRvPromotion() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvPromotion.setLayoutManager(linearLayoutManager);
        PromotionAdapter promotionAdapter = new PromotionAdapter();
        promotionAdapter.setData(homeData.getResult().getListPromotion());
        promotionAdapter.setContext(this);
        rvPromotion.setAdapter(promotionAdapter);
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
        rvPromotion = findViewById(R.id.rv_promotion);

    }
}
