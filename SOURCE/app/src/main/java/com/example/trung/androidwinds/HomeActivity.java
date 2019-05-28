package com.example.trung.androidwinds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class HomeActivity extends AppCompatActivity {
    TextView tvUsername, tvPhoneNumber, tvDangXuat;
    ImageView imgNews1, imgNews2, imgNews3;
    TextView tvNews1, tvNews2, tvNews3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        getData();
        thongTin();
        dangxuat();
        docJson();
    }

    private void docJson() {
        String homeData = loadJSONFromAsset();
        try {
            JSONObject jsonHomeData = new JSONObject(homeData);
            int status = jsonHomeData.getInt("status");
            int code = jsonHomeData.getInt("code");
            String msg = jsonHomeData.getString("message");
            JSONObject jsonResult = jsonHomeData.getJSONObject("result");
            JSONObject jsonCustomerDetail = jsonResult.getJSONObject("customerDetail");
            String customerName = jsonCustomerDetail.getString("customerName");
            JSONArray jsonArrayNews = jsonResult.getJSONArray("listNews");
            // -------------------
            JSONObject jsonNew1 = jsonArrayNews.getJSONObject(0);
            JSONObject jsonNew2 = jsonArrayNews.getJSONObject(1);
            JSONObject jsonNew3 = jsonArrayNews.getJSONObject(2);
            //
            String newsTitle1 = jsonNew1.getString("title");
            String urlNew1 = jsonNew1.getString("urlImage");

            String newsTitle2 = jsonNew2.getString("title");
            String urlNew2 = jsonNew2.getString("urlImage");

            String newsTitle3 = jsonNew3.getString("title");
            String urlNew3 = jsonNew3.getString("urlImage");


            //
            Picasso.get().load(urlNew1).placeholder(R.mipmap.img_default).into(imgNews1);
            Picasso.get().load(urlNew2).placeholder(R.mipmap.img_default).into(imgNews2);
            Picasso.get().load(urlNew3).placeholder(R.mipmap.img_default).into(imgNews3);



            tvNews1.setText(newsTitle1);
            tvNews2.setText(newsTitle2);
            tvNews3.setText(newsTitle3);


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    public String loadJSONFromAsset() {
        String str = null;
        try {
            InputStream is = getAssets().open("home.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            str = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return str;
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
        imgNews1 = findViewById(R.id.img_news_1);
        imgNews2 = findViewById(R.id.img_news_2);
        imgNews3 = findViewById(R.id.img_news_3);
        tvNews1 = findViewById(R.id.tv_new_1);
        tvNews2 = findViewById(R.id.tv_new_2);
        tvNews3 = findViewById(R.id.tv_new_3);
    }
}
