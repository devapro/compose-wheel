package com.example.composeexample.ui.components.wheel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

// TODO set width as param
// TODO set font as param
@Composable
fun WheelRow(
    wheelItemModel: WheelItemModel,
    modifier: Modifier,
    textModifier: Modifier = Modifier,
    showTopDivider: Boolean = true,
    showBottomDivider: Boolean = true
) {
    Column(
        modifier = modifier
            .width(60.dp)
    ) {
        Spacer(
            modifier = Modifier.height(2.dp)
                .fillMaxWidth()
                .background(
                    color = Color.Yellow,
                    shape = RoundedCornerShape(0.5.dp)
                )
                .alpha(if (showTopDivider) 1f else 0f)
        )
        Text(
            modifier = textModifier.fillMaxWidth().padding(8.dp),
            textAlign = TextAlign.Center,
            text = wheelItemModel.message,
            maxLines = 1
        )
        if (showBottomDivider) {
            Spacer(
                modifier = Modifier.height(2.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.Yellow,
                        shape = RoundedCornerShape(0.5.dp)
                    )
                    .alpha(if (showBottomDivider) 1f else 0f)
            )
        }
    }
}