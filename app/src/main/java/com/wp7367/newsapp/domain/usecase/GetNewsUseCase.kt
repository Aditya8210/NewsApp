package com.wp7367.newsapp.domain.usecase

import com.wp7367.newsapp.domain.model.News
import com.wp7367.newsapp.domain.repository.NewsRepository
import com.wp7367.newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<News>>> {
        return repository.getNews(query)
    }
}
