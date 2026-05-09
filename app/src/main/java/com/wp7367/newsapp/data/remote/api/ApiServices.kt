package com.wp7367.newsapp.data.remote.api

import com.wp7367.newsapp.data.remote.dto.NewsDto
import com.wp7367.newsapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<NewsDto>

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("category") category: String,
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<NewsDto>
}
