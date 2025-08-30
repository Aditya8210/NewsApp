package com.wp7367.newsapp.network

import com.wp7367.newsapp.network.resources.NewsModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {


    //  https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=key

    //  https://newsapi.org/v2/everything?q=tesla&from=2025-07-29&sortBy=publishedAt&apiKey



    @GET("everything")
    suspend fun getNews(
        @Query("q") country: String = "tesla",
//        @Query("category") category: String = "business",
//        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "d869655d2b904566bbbf9fd2ce5809b0"
    ):Response<NewsModels>
}