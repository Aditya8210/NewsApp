package com.wp7367.newsapp.data.remote.mapper

import com.wp7367.newsapp.data.remote.dto.ArticleDto
import com.wp7367.newsapp.domain.model.News

fun ArticleDto.toDomain(): News {
    return News(
        title = this.title ?: "No Title",
        description = this.description,
        author = this.author,
        urlToImage = this.urlToImage,
        url = this.url ?: "",
        publishedAt = this.publishedAt ?: "",
        sourceName = this.source?.name ?: "Unknown"
    )
}
