package com.ironmeddie.test_task2.presentation.screens.main_screen.components

import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ironmeddie.test_task2.domain.models.Products

@Composable
fun Tabs(products: Products) {
    TabRow(selectedTabIndex = 0) {

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTabs(){

}