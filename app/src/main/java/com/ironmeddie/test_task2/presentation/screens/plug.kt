package com.ironmeddie.test_task2.presentation.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ironmeddie.test_task2.presentation.screens.routes.Routes


fun NavGraphBuilder.Plug(){
    composable(Routes.Cart.route){
        Zatichka("Cart")
    }
    composable(Routes.Favorite.route){
        Zatichka("Favorite")
    }
    composable(Routes.Profile.route){
        Zatichka("Profile")
    }
    composable(Routes.Catalog.route){
        Zatichka("Catalog")
    }

}

@Composable
fun Zatichka(screen: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "это $screen экран")
    }
}

