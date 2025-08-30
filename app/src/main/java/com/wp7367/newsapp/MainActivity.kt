package com.wp7367.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels // Import for by viewModels()
import androidx.compose.foundation.layout.Box // Import for Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding // Import for padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.wp7367.newsapp.ui.theme.NewsAppTheme
import com.wp7367.newsapp.ui_layer.screen.HomeUi
import com.wp7367.newsapp.ui_layer.screen.MyViewModel // Import MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // Get the ViewModel instance using Hilt
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Box(modifier = Modifier.padding(innerPadding)) {
                        HomeUi(myViewModel = myViewModel) // Pass the ViewModel to HomeUi
                    }
                }
            }
        }
    }
}


