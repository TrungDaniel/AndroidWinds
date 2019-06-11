package com.example.trung.androidwinds.Controller.Main.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trung.androidwinds.Model.News;
import com.example.trung.androidwinds.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{
    public List<News> data;
    public Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<News> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item_layout,viewGroup,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
        News news = data.get(i);
        newsViewHolder.tvDefault.setText(news.getTitle());
        Picasso.get().load(news.getUrlImage()).into(newsViewHolder.imgDefault);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        ImageView imgDefault;
        TextView tvDefault;
        Button btnDefault;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDefault = itemView.findViewById(R.id.img_default);
            tvDefault = itemView.findViewById(R.id.tv_default);
            btnDefault = itemView.findViewById(R.id.btn_default);

        }
    }
}
