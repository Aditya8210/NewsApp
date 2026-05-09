package com.wp7367.newsapp.domain.model

data class News(
    val title: String,
    val description: String?,
    val author: String?,
    val urlToImage: String?,
    val url: String,
    val publishedAt: String,
    val sourceName: String
)
