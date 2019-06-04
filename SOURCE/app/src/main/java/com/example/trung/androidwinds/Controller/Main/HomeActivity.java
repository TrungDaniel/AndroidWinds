package com.example.trung.androidwinds.Controller.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trung.androidwinds.Utils.AppConfig;
import com.example.trung.androidwinds.Controller.Auth.LoginActivity;
import com.example.trung.androidwinds.Model.HomeData;
import com.example.trung.androidwinds.R;
import com.example.trung.androidwinds.Utils.Utils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {
    TextView tvUsername, tvPhoneNumber, tvDangXuat;
    ImageView imgNews1, imgNews2, imgNews3, imgCtth1, imgCtth2, imgCtth3;
    TextView tvNews1, tvNews2, tvNews3, tvCtth1, tvCtth2, tvCtth3;
    RecyclerView recyclerView;

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

    private void configRvNews() {

    }

    private void docJson() {
        String strhomeData = Utils.loadJSONFromAsset(this);
        Gson gson = new Gson();
        HomeData homeData = gson.fromJson(strhomeData, HomeData.class);
        //newsTitle
        String newsTitle1 = homeData.getResult().getListNews().get(0).getTitle();
        String newsTitle2 = homeData.getResult().getListNews().get(1).getTitle();
        String newsTitle3 = homeData.getResult().getListNews().get(2).getTitle();
        //NewsUrl
        String newsUrl1 = homeData.getResult().getListNews().get(0).getUrlImage();
        String newsUrl2 = homeData.getResult().getListNews().get(1).getUrlImage();
        String newsUrl3 = homeData.getResult().getListNews().get(2).getUrlImage();
        //----------
        //promotionTitle
        String promotionTitle1 = homeData.getResult().getListPromotion().get(0).getTitle();
        String promotionTitle2 = homeData.getResult().getListPromotion().get(1).getTitle();
        String promotionTitle3 = homeData.getResult().getListPromotion().get(2).getTitle();
        //promotionUrl
        String promotionUrl1 = homeData.getResult().getListPromotion().get(0).getUrlImage();
        String promotionUrl2 = homeData.getResult().getListPromotion().get(1).getUrlImage();
        String promotionUrl3 = homeData.getResult().getListPromotion().get(2).getUrlImage();
        // setdata
         /*
        Picasso.get().load(newsUrl1).placeholder(R.mipmap.img_default).into(imgNews1);
        Picasso.get().load(newsUrl2).placeholder(R.mipmap.img_default).into(imgNews2);
        Picasso.get().load(newsUrl3).placeholder(R.mipmap.img_default).into(imgNews3);

        Picasso.get().load(promotionUrl1).placeholder(R.mipmap.img_default).into(imgCtth1);
        Picasso.get().load(promotionUrl2).placeholder(R.mipmap.img_default).into(imgCtth2);
        Picasso.get().load(promotionUrl3).placeholder(R.mipmap.img_default).into(imgCtth3);


        tvNews1.setText(newsTitle1);
        tvNews2.setText(newsTitle2);
        tvNews3.setText(newsTitle3);

        tvCtth1.setText(promotionTitle1);
        tvCtth2.setText(promotionTitle2);
        tvCtth3.setText(promotionTitle3);
        */


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
       /*
        imgNews1 = findViewById(R.id.img_news_1);
        imgNews2 = findViewById(R.id.img_news_2);
        imgNews3 = findViewById(R.id.img_news_3);
        tvNews1 = findViewById(R.id.tv_new_1);
        tvNews2 = findViewById(R.id.tv_new_2);
        tvNews3 = findViewById(R.id.tv_new_3);
        */
        recyclerView = findViewById(R.id.rv_news);
        imgCtth1 = findViewById(R.id.img_ctth1);
        imgCtth2 = findViewById(R.id.img_ctth2);
        imgCtth3 = findViewById(R.id.img_ctth3);
        tvCtth1 = findViewById(R.id.tv_ctth1);
        tvCtth2 = findViewById(R.id.tv_ctth2);
        tvCtth3 = findViewById(R.id.tv_ctth3);
    }
}
