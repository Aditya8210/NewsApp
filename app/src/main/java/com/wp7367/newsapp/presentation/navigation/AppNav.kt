package com.wp7367.newsapp.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.wp7367.newsapp.presentation.ui.screens.details.DetailsScreen
import com.wp7367.newsapp.presentation.ui.screens.home.HomeScreen
import com.wp7367.newsapp.presentation.viewmodel.NewsViewModel

@Composable
fun AppNav(
    viewModel: NewsViewModel,
    innerPadding: PaddingValues
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeScreen,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable<HomeScreen> {
            HomeScreen(
                viewModel = viewModel,
                onArticleClick = { url ->
                    navController.navigate(DetailsScreen(url = url))
                }
            )
        }
        composable<DetailsScreen> { backStackEntry ->
            val details: DetailsScreen = backStackEntry.toRoute()
            DetailsScreen(
                url = details.url,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
