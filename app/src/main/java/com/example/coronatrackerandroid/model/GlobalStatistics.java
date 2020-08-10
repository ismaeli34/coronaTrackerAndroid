package com.example.coronatrackerandroid.model;

import com.google.gson.annotations.SerializedName;

public class GlobalStatistics {
    @SerializedName("cases")
    private int cases;
    @SerializedName("deaths")
    private int deaths;
    @SerializedName("recovered")
    private int recovered;
    @SerializedName("active")
    private int active;
    @SerializedName("todayRecovered")
    private int todayRecovered;
//    @SerializedName("todayCases")
//    private int todayActive;
    @SerializedName("todayCases")
    private int todayCases;
    @SerializedName("todayDeaths")
    private int todayDeaths;

    public GlobalStatistics() {

    }

    @SerializedName("critical")
    private int critical;

    public int getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(int todayRecovered) {
        this.todayRecovered = todayRecovered;
    }
//
//    public int getTodayActive() {
//        return todayActive;
//    }

//    public void setTodayActive(int todayActive) {
//        this.todayActive = todayActive;
//    }




    public GlobalStatistics(int cases, int todayCases, int deaths, int todayDeaths, int recovered,int active,int critical,int todayRecovered) {
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
        this.todayRecovered = todayRecovered;
//        this.todayActive = todayActive;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
