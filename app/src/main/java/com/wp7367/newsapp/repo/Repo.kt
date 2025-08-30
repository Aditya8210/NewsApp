package com.wp7367.newsapp.repo

import com.wp7367.newsapp.network.ApiServices
import com.wp7367.newsapp.network.resources.NewsModels
import retrofit2.Response
import javax.inject.Inject


class Repo @Inject constructor(
    private val apiServices: ApiServices
) {

    suspend fun getNewsRepo(): Response<NewsModels> {
        return apiServices.getNews()
    }
}