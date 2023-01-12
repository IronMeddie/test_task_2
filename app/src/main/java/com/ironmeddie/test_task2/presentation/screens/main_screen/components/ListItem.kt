package com.ironmeddie.test_task2.presentation.screens.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ironmeddie.test_task2.R
import com.ironmeddie.test_task2.common.utils.UtilConstants.BASE_URL
import com.ironmeddie.test_task2.common.utils.log
import com.ironmeddie.test_task2.domain.models.ItemData

@Composable
fun ListItem(item : ItemData) {
    Card(backgroundColor = Color.White, elevation = 1.dp , modifier = Modifier.padding(3.dp)) {
        Box(modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
           ) {
            AsyncImage(model = item.picture, contentDescription = null, modifier = Modifier
                .padding(5.dp)
                .size(150.dp), contentScale = ContentScale.Crop)

            Icon(
                imageVector =  if (item.favorite) Icons.Default.Favorite  else Icons.Default.FavoriteBorder ,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp),
                tint = MaterialTheme.colors.onBackground
            )
            Text(text = item.extendedPrice.first().price.toString() + " ₽", modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp))
            Box(modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape)
                .size(26.dp)
                .align(Alignment.BottomEnd)
                .background(MaterialTheme.colors.primaryVariant), contentAlignment = Alignment.Center) {

                Icon(painter  =painterResource(id = R.drawable.shopping_basket) , contentDescription = null, tint = MaterialTheme.colors.onSurface, modifier = Modifier.size(21.dp))
            }
        }
    }

}