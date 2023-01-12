package com.ironmeddie.test_task2.presentation.screens.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ironmeddie.test_task2.R

@Composable
fun ExampleWater() {
    Card(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.padding(3.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(model = "https://aquabalt.ru/imgs/products/2980/thumb/2980-1662379566.jpg", contentDescription = "example", modifier = Modifier.height(100.dp))
            Column() {
                Text(text = stringResource(R.string.example_title))
                Text(text = stringResource(R.string.example_descr), style = MaterialTheme.typography.subtitle1 , maxLines = 3)
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(text = stringResource(R.string.example_sale_price), style = MaterialTheme.typography.body2)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = stringResource(R.string.example_price_without_sale) , textDecoration = TextDecoration.LineThrough)
                    }
                    Box(modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .size(26.dp)
                        .background(MaterialTheme.colors.primaryVariant), contentAlignment = Alignment.Center) {
                        Icon(painter  = painterResource(id = R.drawable.shopping_basket) , contentDescription = null, tint = MaterialTheme.colors.onSurface, modifier = Modifier.size(21.dp))
                    }
                }
            }
        }
    }
}