package com.ironmeddie.test_task2.presentation.screens.main_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ironmeddie.test_task2.R
import com.ironmeddie.test_task2.presentation.screens.main_screen.navigation.mainScreenRoute
import com.ironmeddie.test_task2.presentation.screens.routes.Routes

@Composable
fun BottomNavigationMenu(navController: NavController, cartPrice: String) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val menu = listOf(
        MenuItem(Icons.Default.Home,stringResource(R.string.main), mainScreenRoute),
        MenuItem(Icons.Default.MenuOpen, stringResource(R.string.catalog), Routes.Catalog.route),
        MenuItem(Icons.Default.ShoppingBasket,cartPrice, Routes.Cart.route),
        MenuItem(Icons.Default.FavoriteBorder, stringResource(R.string.favorite), Routes.Favorite.route ),
        MenuItem(Icons.Default.Person, stringResource(R.string.profile), Routes.Profile.route),
    )
    val navigation: (String) -> Unit = {
        navController.navigate(it) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    BottomNavigation(
        Modifier
            .clip(MaterialTheme.shapes.medium)
            .fillMaxWidth()
            .height(72.dp), backgroundColor = MaterialTheme.colors.surface,
    ) {
        menu.forEach { item->
            BottomNavigationItem(selected = currentDestination?.route == item.route,
                onClick = { navigation(item.route) }, icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(R.string.home_icon),
                        tint = MaterialTheme.colors.onSecondary
                    )
                }, label = {
                    Text(
                        text = item.label, style = MaterialTheme.typography.subtitle1, fontSize = 9.sp
                    )
                })
        }

    }

}

data class MenuItem(val icon : ImageVector, val label : String ,val route: String)