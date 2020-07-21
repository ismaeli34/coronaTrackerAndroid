package com.example.coronatrackerandroid.service;

import com.example.coronatrackerandroid.model.CountryModel;
import com.example.coronatrackerandroid.model.GlobalStatistics;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("all")
    Call<GlobalStatistics> getStatisticsResult();

    @GET("countries")
    Call<List<CountryModel>> getCountries();
}
