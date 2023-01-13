package com.ironmeddie.test_task2.presentation.screens.main_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ironmeddie.test_task2.R
import com.ironmeddie.test_task2.common.utils.DataResource
import com.ironmeddie.test_task2.presentation.screens.main_screen.components.*

@Composable
fun MainScreen(navController: NavController, viewModel: MainScreenViewModel = hiltViewModel()) {

    val state = viewModel.state.collectAsState().value
    val search = viewModel.search.collectAsState().value
    val price = "239 ₽" // получить с сервера


    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        MainScreenTopBar(
            text = search,
            onChangedValue = viewModel::search
        )
    },
    bottomBar = { BottomNavigationMenu(navController = navController, cartPrice = price) }) { paddings ->

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(paddings)) {
            items(3) {
                ExampleWater()
            }
            when (state) {
                is DataResource.Success -> {
                    item {
                        ScrollableRow(state.data.tovary)
                    }
                }
                is DataResource.Loading -> {
                    item {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator()
                        }
                    }
                }
                else ->{
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp), contentAlignment = Alignment.Center
                        ) {
                            Text(text = "conection failure")
                        }
                    }
                }
            }
            item {
                Brands()
            }
            item {
                Spacer(modifier = Modifier.height(4.dp))
            }
            item {
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)) {
                    Text(text = stringResource(R.string.wathed), fontWeight = FontWeight.Bold)
                    Text(text = stringResource(R.string.watchl_all), color = MaterialTheme.colors.primary)
                }
            }
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

