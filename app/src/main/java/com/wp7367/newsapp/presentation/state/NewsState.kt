package com.wp7367.newsapp.presentation.state

import com.wp7367.newsapp.domain.model.News

data class NewsState(
    val isLoading: Boolean = false,
    val data: List<News> = emptyList(),
    val error: String = ""
)
