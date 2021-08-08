package com.example.composeexample.ui.components.wheel

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
internal fun WheelInternal(
    modifier: Modifier = Modifier,
    rowModifier: Modifier = Modifier,
    wheelItemModels: List<WheelItemModel>,
    selectedIndex: Int = 0,
    onItemSelected: (wheelItemModel: WheelItemModel) -> Unit = {}
) {
    val composableScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = modifier
            .padding(1.dp)
    ) {
        item (key = -1) {
            EmptyRow()
        }
        itemsIndexed(
            items = wheelItemModels,
            key = { index, message ->
                "${index}_${message.id}"
            }
        ) { index, message ->

            //TODO менять цвет / фон / шрифт
            val updatedTextModifier = if (listState.firstVisibleItemIndex == index) {
                Modifier.alpha(1f)
            } else {
                Modifier.alpha(0.2f)
            }

            WheelRow(
                wheelItemModel = message,
                modifier = rowModifier,
                textModifier = updatedTextModifier,
                showTopDivider = true,
                showBottomDivider = index == wheelItemModels.size - 1
            )
        }
        item (key = -2) {
            EmptyRow()
        }
    }

    val isScrollInProgress by remember {
        derivedStateOf {
            listState.isScrollInProgress
        }
    }

    LaunchedEffect(isScrollInProgress) {
        if(!listState.isScrollInProgress){
            val visiblePlaceHeight = listState.layoutInfo.viewportEndOffset + listState.layoutInfo.viewportStartOffset
            val itemHeight = listState.layoutInfo.visibleItemsInfo.firstOrNull()?.size
            itemHeight?.let {
                val centerPosition = (visiblePlaceHeight - itemHeight) / 2
                val offsetToScroll = itemHeight - centerPosition
                val indexToScroll = when (listState.firstVisibleItemIndex) {
                    listState.layoutInfo.totalItemsCount - 2 -> listState.firstVisibleItemIndex - 1
                    else -> listState.firstVisibleItemIndex
                }
                if (listState.firstVisibleItemScrollOffset != offsetToScroll && offsetToScroll > 0) {
                    composableScope.launch {
                        listState.animateScrollToItem(
                            index = indexToScroll,
                            scrollOffset = offsetToScroll
                        )
                    }
                }
            }
        }
    }
}

@Composable
internal fun EmptyRow() {
    WheelRow(
        WheelItemModel("", -1),
        modifier = Modifier.alpha(0f),
        showTopDivider = false,
        showBottomDivider = false
    )
}