package com.wp7367.newsapp.network.resources

data class NewsModels(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)