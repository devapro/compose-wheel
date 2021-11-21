package pro.devapp.compose.wheel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.layoutId

@Composable
fun WheelBox(
    modifier: Modifier = Modifier,
    template: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier.background(color = LiteGray),
        content = {
            Box(modifier = Modifier.layoutId("templateId")) {
                template.invoke()
            }
            content.invoke()
        }
    ) { measurables, constraints ->
        // List of measured children
        val placeables = mutableListOf<Placeable>()

        val templatePlaceables = measurables
            .filter {
                it.layoutId == "templateId"
            }.map { measurable ->
                // Measure each child
                measurable.measure(constraints)
            }.first()

        val newConstraints = constraints.copy(
            maxHeight = templatePlaceables.height,
            maxWidth = templatePlaceables.width
        )

        val list = measurables
            .filter {
                it.layoutId != "templateId"
            }
            .map { measurable ->
                // Measure each child
                measurable.measure(newConstraints)
            }

        placeables.add(templatePlaceables)
        placeables.addAll(list)

        // Set the size of the layout as big as it can
        layout(newConstraints.maxWidth, newConstraints.maxHeight) {
            // Place children in the parent layout
            placeables.forEach { placeable ->
                // Position item on the screen
                placeable.placeRelative(x = 0, y = 0)
            }
        }
    }
}