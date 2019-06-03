package com.example.trung.androidwinds.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerDetail {

    @SerializedName("customerName")
    @Expose
    public String customerName;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("point")
    @Expose
    public Integer point;
    @SerializedName("isNeedUpate")
    @Expose
    public Integer isNeedUpate;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getIsNeedUpate() {
        return isNeedUpate;
    }

    public void setIsNeedUpate(Integer isNeedUpate) {
        this.isNeedUpate = isNeedUpate;
    }
}