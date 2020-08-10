package com.example.coronatrackerandroid.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL ="https://corona.lmao.ninja/v2/";
    //public static final String NEWS_URL = "https://newsapi.org/v2/everything?q=COVID&sortBy=publishedAt&sources=bbc-news&apiKey=655457aa51f444568e592ade394c78ec&pageSize=50&page=1";


    public static Retrofit getRetrofitInstance(){
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
