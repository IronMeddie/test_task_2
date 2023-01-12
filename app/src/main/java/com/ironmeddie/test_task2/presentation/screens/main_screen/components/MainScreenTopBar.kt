package com.ironmeddie.test_task2.presentation.screens.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ironmeddie.test_task2.presentation.theme.MyTheme

@Composable
fun MainScreenTopBar(text: String, onChangedValue: (String) -> Unit) {

    Box(modifier = Modifier.fillMaxWidth().background(Color.White)) {
        MyTextField(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 2.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(35.dp)
                .background(MaterialTheme.colors.onSurface),
            text = text,
            onValueChange = onChangedValue,
            onFocusChange = {},
            isHintVisible = text.isBlank(),
            textStyle = MaterialTheme.typography.subtitle1
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewTopBar() {
    MyTheme {
        MainScreenTopBar("") {

        }
    }
}