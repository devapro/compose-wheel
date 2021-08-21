package com.example.composeexample.ui.components.wheel

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*

@Composable
internal fun WheelInternal(
    modifier: Modifier = Modifier,
    rowModifier: Modifier = Modifier,
    wheelItemModels: List<WheelItemModel>,
    selectedIndex: Int = 0,
    onItemSelected: (selectedIndex: Int, wheelItemModel: WheelItemModel) -> Unit = {_,_ -> }
) {
    val composableScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    var setManualFlag = false

    LaunchedEffect(selectedIndex) {
        if (!listState.isScrollInProgress) {
            val visiblePlaceHeight =
                listState.layoutInfo.viewportEndOffset + listState.layoutInfo.viewportStartOffset
            val itemHeight = listState.layoutInfo.visibleItemsInfo.firstOrNull()?.size
            itemHeight?.let {
                val centerPosition = (visiblePlaceHeight - itemHeight) / 2
                val offsetToScroll = itemHeight - centerPosition
                val indexToScroll = when (listState.firstVisibleItemIndex) {
                    listState.layoutInfo.totalItemsCount - 2 -> listState.firstVisibleItemIndex - 1
                    else -> {
                        if (itemHeight / 2 < listState.firstVisibleItemScrollOffset) {
                            listState.firstVisibleItemIndex + 1
                        } else {
                            listState.firstVisibleItemIndex
                        }
                    }
                }
                if (indexToScroll != selectedIndex || offsetToScroll > 0) {
                    setManualFlag = true
                    composableScope.launch {
                        listState.scrollToItem(
                            index = selectedIndex,
                            scrollOffset = offsetToScroll
                        )
                    }
                }
            }
        }
    }

    LaunchedEffect(listState.isScrollInProgress) {
        if (!listState.isScrollInProgress) {
            val visiblePlaceHeight =
                listState.layoutInfo.viewportEndOffset + listState.layoutInfo.viewportStartOffset
            val itemHeight = listState.layoutInfo.visibleItemsInfo.firstOrNull()?.size
            itemHeight?.let {
                val centerPosition = (visiblePlaceHeight - itemHeight) / 2
                val offsetToScroll = itemHeight - centerPosition
                val indexToScroll = when (listState.firstVisibleItemIndex) {
                    listState.layoutInfo.totalItemsCount - 2 -> listState.firstVisibleItemIndex - 1
                    else -> {
                        if (itemHeight / 2 < listState.firstVisibleItemScrollOffset) {
                            listState.firstVisibleItemIndex + 1
                        } else {
                            listState.firstVisibleItemIndex
                        }
                    }
                }
                if (!setManualFlag) {
                    composableScope.launch {
                        listState.animateScrollToItem(
                            index = indexToScroll,
                            scrollOffset = offsetToScroll
                        )
                        onItemSelected(indexToScroll, wheelItemModels[indexToScroll])
                    }
                }
            }
        }
    }

    LazyColumn(
        state = listState,
        modifier = modifier
            .padding(0.dp)
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
            val itemHeight = listState.layoutInfo.visibleItemsInfo.firstOrNull()?.size
            val activeIndex = itemHeight?.let {
                if (listState.firstVisibleItemScrollOffset > itemHeight/2) {
                    listState.firstVisibleItemIndex + 1
                } else {
                    listState.firstVisibleItemIndex
                }
            }
            val updatedTextModifier = itemHeight?.let {
                if (activeIndex == index) {
                    Modifier.alpha(1f)
                } else {
                    Modifier.alpha(0.2f)
                }
            } ?: Modifier
            WheelRow(
                wheelItemModel = message,
                modifier = rowModifier,
                textModifier = updatedTextModifier,
                showTopDivider = index == activeIndex,
                showBottomDivider = index == activeIndex
            )
        }
        item (key = -2) {
            EmptyRow()
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