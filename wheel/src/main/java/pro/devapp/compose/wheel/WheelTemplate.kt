package pro.devapp.compose.wheel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun WheelTemplate(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .wrapContentHeight()
    ) {
        EmptyRow()
        EmptyRow()
        EmptyRow()
    }
}