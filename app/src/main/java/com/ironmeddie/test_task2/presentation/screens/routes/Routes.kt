package com.ironmeddie.test_task2.presentation.screens.routes

sealed class Routes(val route: String) {
    object Cart : Routes("Cart")
    object Profile : Routes("Profile")
    object Favorite : Routes("Favorite")
    object Catalog : Routes("Catalog")
}
