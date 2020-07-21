package com.example.coronatrackerandroid.model;

import com.google.gson.annotations.SerializedName;

public class CountryInfo {
    @SerializedName("flag")
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
