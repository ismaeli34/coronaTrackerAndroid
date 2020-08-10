package com.example.coronatrackerandroid.model;

public class CountryModel {


    private String flag;
    private String country;
    private String todayCases;
    private String deaths;
    private String todayDeaths;
    private String todayRecovereds;
    private String todayActive;
    private String recovered;
    private String active;
    private String critical;
    private String totalDeath;
    private String cases;
    private CountryInfo countryInfo;

    public CountryModel() {
    }

    public String getFlag() {
        return flag;
    }

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTotalDeath() {
        return totalDeath;
    }

    public void setTotalDeath(String totalDeath) {
        this.totalDeath = totalDeath;
    }

    public String getTodayRecovereds() {
        return todayRecovereds;
    }

    public void setTodayRecovereds(String todayRecovereds) {
        this.todayRecovereds = todayRecovereds;
    }

    public String getTodayActive() {
        return todayActive;
    }

    public void setTodayActive(String todayActive) {
        this.todayActive = todayActive;
    }

    public CountryModel(String flag, String country, String todayCases, String deaths, String todayDeaths, String recovered, String active, String critical,String cases,String todayRecovereds,String todayActive) {
        this.flag = flag;
        this.country = country;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
        this.cases = cases;
        this.todayRecovereds = todayRecovereds;
        this.todayActive = todayActive;
    }
}
