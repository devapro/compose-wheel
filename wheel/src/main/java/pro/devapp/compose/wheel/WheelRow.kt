package pro.devapp.compose.wheel

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

private val defaultModifier = Modifier.width(60.dp)
private val defaultSpacerModifier = Modifier.height(2.dp)
    .fillMaxWidth()
    .background(
        color = Color.Yellow,
        shape = RoundedCornerShape(0.5.dp)
    )
private val defaultTextModifier = Modifier.fillMaxWidth().padding(8.dp)

@Composable
fun WheelRow(
    wheelItemModel: WheelItemModel,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    spacerModifier: Modifier = Modifier,
    showTopDivider: Boolean = true,
    showBottomDivider: Boolean = true
) {
    Column(
        modifier = defaultModifier.then(modifier)
    ) {
        Spacer(
            modifier = Modifier
                .alpha(if (showTopDivider) 1f else 0f)
                .then(defaultSpacerModifier)
                .then(spacerModifier)
        )
        Text(
            modifier = defaultTextModifier.then(textModifier),
            textAlign = TextAlign.Center,
            text = wheelItemModel.name,
            maxLines = 1
        )
        Spacer(
            modifier = Modifier
                .alpha(if (showBottomDivider) 1f else 0f)
                .then(defaultSpacerModifier)
                .then(spacerModifier)
        )
    }
}