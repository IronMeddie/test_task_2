package com.ironmeddie.test_task2.presentation.screens.main_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ironmeddie.test_task2.R

@Composable
fun Brands(){
    Column(Modifier.fillMaxWidth()) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {
            Text(text = stringResource(R.string.brands), fontWeight = FontWeight.Bold)
            Text(text = stringResource(R.string.watchl_all), color = MaterialTheme.colors.primary)
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Card(modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .height(120.dp), backgroundColor = Color.White, elevation = 10.dp) {
                Box(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(), contentAlignment = Alignment.Center) {
                    AsyncImage(model = "https://www.coffee-butik.ru/upload/medialibrary/b17/b1778e9426bc7cd501364ef727859f67.png", contentDescription = null, contentScale = ContentScale.FillWidth)
                }

            }
            Card(modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .height(120.dp), backgroundColor = Color.White , elevation = 10.dp) {
                Box(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(), contentAlignment = Alignment.Center) {
                    AsyncImage(model = "https://tmsearch.onlinepatent.ru/images/350/350beb31-cc35-4a94-bb03-99b8238117da.jpg", contentDescription = null, contentScale = ContentScale.FillWidth)
                }
            }
            Card(modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .height(120.dp), backgroundColor = Color.White, elevation = 10.dp) {
                Box(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(), contentAlignment = Alignment.Center) {
                    AsyncImage(model = "http://orehovo.omsu.inlite.ru/files/image/34/63/67/lg!43e.jpg", contentDescription = null, contentScale = ContentScale.FillWidth)
                }
            }
        }
    }
}