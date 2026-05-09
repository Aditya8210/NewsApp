package com.wp7367.newsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wp7367.newsapp.domain.usecase.GetNewsUseCase
import com.wp7367.newsapp.domain.usecase.GetTopHeadlinesUseCase
import com.wp7367.newsapp.presentation.state.NewsState
import com.wp7367.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(NewsState())
    val state: StateFlow<NewsState> = _state.asStateFlow()

    init {
        getTopHeadlines("general")
    }

    fun getNews(query: String) {
        getNewsUseCase(query).onEach { result ->
            _state.value = when (result) {
                is Resource.Success -> {
                    NewsState(data = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    NewsState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getTopHeadlines(category: String) {
        getTopHeadlinesUseCase(category).onEach { result ->
            _state.value = when (result) {
                is Resource.Success -> {
                    NewsState(data = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    NewsState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
