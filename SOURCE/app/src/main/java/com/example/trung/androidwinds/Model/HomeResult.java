package com.example.trung.androidwinds.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

@SerializedName("customerDetail")
@Expose
public CustomerDetail customerDetail;
@SerializedName("listNews")
@Expose
public List<News> listNews = null;
@SerializedName("listPromotion")
@Expose
public List<Promotion> listPromotion = null;

}