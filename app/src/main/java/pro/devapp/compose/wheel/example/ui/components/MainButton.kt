package pro.devapp.compose.wheel.example.ui.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pro.devapp.compose.wheel.example.ui.theme.MainButtonColor

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