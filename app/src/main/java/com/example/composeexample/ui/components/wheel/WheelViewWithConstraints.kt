package com.example.composeexample.ui.components.wheel

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun WheelViewWithConstraints(
    modifier: Modifier = Modifier,
    wheelItemModels: List<WheelItemModel>,
    selectedIndex: Int = 0,
    onItemSelected: (wheelItemModel: WheelItemModel) -> Unit = {}
) {
    ConstraintLayout(
        modifier = Modifier.wrapContentSize()
    ) {
        val (template, wheel) = createRefs()
        WheelTemplate(
            modifier = Modifier
                .wrapContentHeight()
                .layoutId(1)
                .constrainAs(template) {
                    top.linkTo(parent.top)
                }
        )
        WheelInternal(
            wheelItemModels = wheelItemModels,
            modifier = modifier
                .padding(1.dp) // 70.dp
                .constrainAs(wheel) {
                    top.linkTo(template.top)
                    bottom.linkTo(template.bottom)
                    start.linkTo(parent.start)
                    height = Dimension.fillToConstraints
                    width = Dimension.preferredWrapContent
                }
        )
    }
}