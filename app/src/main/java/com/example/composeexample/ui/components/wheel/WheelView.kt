package com.example.composeexample.ui.components.wheel

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WheelView(
    modifier: Modifier = Modifier,
    messages: List<WheelItemModel>,
    selectedIndex: Int = 0,
    onItemSelected: (wheelItemModel: WheelItemModel) -> Unit = {}
) {
    WheelBox(
        modifier = Modifier.wrapContentSize(),
        template = {
            WheelTemplate()
        }
    ) {
        WheelInternal(
            modifier = modifier,
            wheelItemModels = messages,
            selectedIndex = selectedIndex,
            onItemSelected = onItemSelected
        )
    }
}