package com.ironmeddie.test_task2.presentation.screens.main_screen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ironmeddie.test_task2.presentation.screens.main_screen.MainScreen

const val mainScreenRoute = "main_screen_naviration_route"

fun NavGraphBuilder.Main(navController:NavController){
    composable(mainScreenRoute){
        MainScreen(navController)
    }
}

fun NavController.navigateToMainScreen(navOptions: NavOptions? = null){
    this.navigate(mainScreenRoute, navOptions)
}