package com.wp7367.newsapp.data.repository

import com.wp7367.newsapp.data.remote.api.ApiServices
import com.wp7367.newsapp.data.remote.mapper.toDomain
import com.wp7367.newsapp.domain.model.News
import com.wp7367.newsapp.domain.repository.NewsRepository
import com.wp7367.newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiServices: ApiServices
) : NewsRepository {
    
    override fun getNews(query: String): Flow<Resource<List<News>>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiServices.getNews(query = query)
            if (response.isSuccessful) {
                val articles = response.body()?.articles?.map { it.toDomain() } ?: emptyList()
                emit(Resource.Success(articles))
            } else {
                emit(Resource.Error(response.message()))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown Error"))
        }
    }

    override fun getTopHeadlines(category: String): Flow<Resource<List<News>>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiServices.getTopHeadlines(category = category)
            if (response.isSuccessful) {
                val articles = response.body()?.articles?.map { it.toDomain() } ?: emptyList()
                emit(Resource.Success(articles))
            } else {
                emit(Resource.Error(response.message()))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown Error"))
        }
    }
}
