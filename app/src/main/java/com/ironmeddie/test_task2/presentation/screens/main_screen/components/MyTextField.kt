package com.ironmeddie.test_task2.presentation.screens.main_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DocumentScanner
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.ironmeddie.test_task2.R
import com.ironmeddie.test_task2.presentation.theme.GreyIcons

@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = stringResource(R.string.search_in_vodovoz) ,
    isHintVisible: Boolean = true,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    bodyAlign: Alignment = Alignment.CenterStart,
    maxLnes: Int = 20,
    onFocusChange: (FocusState) -> Unit
) {
    Box(modifier = modifier) {
        BasicTextField(value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            maxLines = maxLnes,
            modifier = Modifier
                .matchParentSize()
                .onFocusChanged { onFocusChange(it) }
                .align(bodyAlign)
                .wrapContentWidth()
        )
        if (isHintVisible) {
        Row(modifier = Modifier.align(Alignment.CenterStart), verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_textfield_icon)
                    , tint = GreyIcons)
                Text(
                    text = hint,
                    style = textStyle,
                    color = GreyIcons,

                )
            }
        }
        Icon(imageVector = Icons.Default.DocumentScanner,
            contentDescription = "barcode scann",
            modifier= Modifier.align(Alignment.CenterEnd), tint = GreyIcons)
        

    }


}
