package com.ironmeddie.test_task2.presentation.screens.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.stopScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ironmeddie.test_task2.R
import com.ironmeddie.test_task2.common.utils.log
import com.ironmeddie.test_task2.domain.models.ExtendedPrice
import com.ironmeddie.test_task2.domain.models.ItemData
import com.ironmeddie.test_task2.domain.models.Nalichie
import com.ironmeddie.test_task2.domain.models.Tovary
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

/*
В задании написано, что списки товаров должны переключаться, но с сервера приходит только один. Поэтому тут создаю фейковый
 */


@Composable
fun ScrollableRow(tovary: List<Tovary>) {

    val listState = rememberLazyListState(Int.MAX_VALUE / 2)
    val coroutineScope = rememberCoroutineScope()
    var list = remember { mutableStateOf(tovary[0].data)}
    var selected by remember { mutableStateOf(0) }
    val pages = tovary.map { it.name }.toMutableList()
    if (tovary.size<2) {
        pages.add(stringResource(R.string.for_us))
    }


    Column(modifier = Modifier.background(MaterialTheme.colors.surface)) {
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
        ) {
            pages.forEachIndexed { index, title ->
                item {
                    Button(onClick = {
                        coroutineScope.launch {
                            if (listState.isScrollInProgress) listState.stopScroll()
                            selected = index
                            list.value = if (selected == 0) tovary[selected].data else getFakeTovary()

                        }

                    }, colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface)) {
                        Text(
                            title,
                            fontSize = 12.sp,
                            color = if (selected == index) MaterialTheme.colors.secondary else MaterialTheme.colors.onBackground
                        )
                    }
                    Spacer(modifier = Modifier.width(3.dp))
                }

            }
        }

        LazyRow(state = listState) {
            items(Int.MAX_VALUE, itemContent = {
                val index = it % list.value.size
                ListItem(item = list.value[index])   // item composable
            }, key = { val index = it % list.value.size
                         list.value[index].id })
//            items(list.value) {
//                ListItem(it)
//            }
        }
    }



}



private fun getFakeTovary() : List<ItemData> {
    val pictures = listOf(
        "http://m.vodovoz.ru/upload/iblock/aee/aee461c0926d12c25780ac1d6f7d5205.jpg",
        "https://kupiopt.com/images/detailed/7/40b42641-04f2-44be-85d3-eb0e46771c25.jpg",
        "https://kupivody.ru/wp-content/uploads/2021/08/baikal_water085_bezgaza.jpg",
        "https://avatars.mds.yandex.net/get-mpic/5454584/img_id1837903841357713526.png/orig",
        "https://avatars.mds.yandex.net/get-mpic/5318100/img_id7571127628087366021.jpeg/orig",
        "https://avatars.mds.yandex.net/get-mpic/3698270/img_id5396385609133026479.jpeg/orig",
        "https://avatars.mds.yandex.net/get-mpic/5344732/img_id6996260230335797923.jpeg/orig",
        "https://avatars.mds.yandex.net/get-mpic/4737085/img_id6043961133070874330.jpeg/orig",
    )
    return  listOf(
                ItemData(id = Random.nextInt().toString(), picture = pictures.random(), emptyList(), nalichie = Nalichie("","","","",""),"Архыз",4.8, false,
                    listOf(ExtendedPrice(oldPrice = 235,210,15,43))
                ),
                ItemData(id = Random.nextInt().toString(), picture = pictures.random(), emptyList(), nalichie = Nalichie("","","","",""),"Архыз",4.8, false,
                    listOf(ExtendedPrice(oldPrice = 235,210,15,43))
                ),ItemData(id = Random.nextInt().toString(), picture = pictures.random(), emptyList(), nalichie = Nalichie("","","","",""),"Архыз",4.8, false,
                    listOf(ExtendedPrice(oldPrice = 235,210,15,43))
                ),ItemData(id = Random.nextInt().toString(), picture = pictures.random(), emptyList(), nalichie = Nalichie("","","","",""),"Архыз",4.8, false,
                    listOf(ExtendedPrice(oldPrice = 235,210,15,43))
                ),ItemData(id = Random.nextInt().toString(), picture = pictures.random(), emptyList(), nalichie = Nalichie("","","","",""),"Архыз",4.8, false,
                    listOf(ExtendedPrice(oldPrice = 235,210,15,43))
                ),ItemData(id = Random.nextInt().toString(), picture = pictures.random(), emptyList(), nalichie = Nalichie("","","","",""),"Архыз",4.8, false,
                    listOf(ExtendedPrice(oldPrice = 235,210,15,43))
                )
            )


}
