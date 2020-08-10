package com.example.coronatrackerandroid.service;

import com.example.coronatrackerandroid.model.CountryModel;
import com.example.coronatrackerandroid.model.GlobalStatistics;
import com.example.coronatrackerandroid.model.NewsModel;
import com.example.coronatrackerandroid.model.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("all")
    Call<GlobalStatistics> getStatisticsResult();

    @GET("countries")
    Call<List<CountryModel>> getCountries();

    @GET("https://newsapi.org/v2/everything?q=COVID&sortBy=publishedAt&sources=bbc-news&apiKey=655457aa51f444568e592ade394c78ec&pageSize=50&page=1")
    Call<NewsResponse> getNews();
}
