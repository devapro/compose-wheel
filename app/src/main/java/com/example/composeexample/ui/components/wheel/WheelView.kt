package com.example.composeexample.ui.components.wheel

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun WheelView(
    modifier: Modifier = Modifier,
    messages: List<WheelItemModel>,
    selectedIndex: Int = 0,
    onItemSelected: (wheelItemModel: WheelItemModel) -> Unit = {}
) {
    val (currentIndex, setCurrentIndex) = remember {mutableStateOf(selectedIndex)}
    WheelBox(
        modifier = Modifier.wrapContentSize(),
        template = {
            WheelTemplate()
        }
    ) {
        WheelInternal(
            modifier = modifier,
            wheelItemModels = messages,
            selectedIndex = currentIndex,
            onItemSelected = {index, model ->
                setCurrentIndex(index)
                onItemSelected(model)
            }
        )
    }
}