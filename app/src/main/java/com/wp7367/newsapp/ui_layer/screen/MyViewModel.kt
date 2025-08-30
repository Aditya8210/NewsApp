package com.wp7367.newsapp.ui_layer.screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wp7367.newsapp.Const.ResultState
import com.wp7367.newsapp.network.resources.NewsModels
import com.wp7367.newsapp.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {


    private val _newsState = mutableStateOf<ResultState<NewsModels>>(ResultState.Loading)
    val newsState: State<ResultState<NewsModels>> = _newsState

    init {
        fetchNews()
    }

    fun fetchNews() {
        // Set state to Loading before starting the fetch
        _newsState.value = ResultState.Loading
        viewModelScope.launch {
            try {
                val response = repo.getNewsRepo()
                if (response.isSuccessful && response.body() != null) {
                    _newsState.value = ResultState.Success(response.body()!!)
                } else {
                    // Handle HTTP errors or null body
                    val errorMessage = "Error: ${response.code()} ${response.message()}"
                    _newsState.value = ResultState.Error(errorMessage)

                }
            } catch (e: Exception) {
                val exceptionMessage = "Exception: ${e.message ?: "Unknown error"}"
                _newsState.value = ResultState.Error(exceptionMessage)

            }
        }
    }
}
