package com.wp7367.newsapp.domain.repository

import com.wp7367.newsapp.domain.model.News
import com.wp7367.newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(query: String): Flow<Resource<List<News>>>
    fun getTopHeadlines(category: String): Flow<Resource<List<News>>>
}
