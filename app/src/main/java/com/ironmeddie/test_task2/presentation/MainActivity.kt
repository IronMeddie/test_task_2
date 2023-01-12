package com.ironmeddie.test_task2.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ironmeddie.test_task2.presentation.screens.Plug
import com.ironmeddie.test_task2.presentation.screens.main_screen.navigation.Main
import com.ironmeddie.test_task2.presentation.screens.main_screen.navigation.mainScreenRoute
import com.ironmeddie.test_task2.presentation.theme.MyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                val navController = rememberNavController()
                NavHost(navController= navController , startDestination = mainScreenRoute){
                    Main(navController)
                    Plug()
                }
            }
        }
    }
}

