package com.example.composeexample.ui.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeexample.ui.theme.MainButtonColor

@Composable
fun MainButton() {
    Button(
        onClick = { /*TODO*/ },
        colors = MainButtonColor,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(100.dp)
    ) {
        Text(text = "Button")
    }
}