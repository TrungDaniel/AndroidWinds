package com.example.trung.androidwinds.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {

@SerializedName("newsID")
@Expose
public Integer newsID;
@SerializedName("urlImage")
@Expose
public String urlImage;
@SerializedName("type")
@Expose
public Integer type;
@SerializedName("title")
@Expose
public String title;
@SerializedName("content")
@Expose
public String content;
@SerializedName("createDate")
@Expose
public String createDate;
@SerializedName("createDateStr")
@Expose
public String createDateStr;

    public Integer getNewsID() {
        return newsID;
    }

    public void setNewsID(Integer newsID) {
        this.newsID = newsID;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }
}