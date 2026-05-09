package com.wp7367.newsapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Serializable
data class DetailsScreen(val url: String)
