package com.example.detikcomclone.api;

import com.example.detikcomclone.model.headlines.NewsResponse;
import com.example.detikcomclone.model.headlines.allsource.All_Source_Respons;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/v2/top-headlines")
    Call<NewsResponse> getHeadLines(@Query("country") String country, @Query("apiKey") String apiKey);

    @GET("/v2/top-headlines")
    Call<NewsResponse> getListAllNewsCategory(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);


    @GET("/v2/sources")
    Call<All_Source_Respons> getListAllSource(@Query("category") String category,@Query("apiKey") String apiKey);
}
