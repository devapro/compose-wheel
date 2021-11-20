package pro.devapp.compose.wheel.example.ui.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import pro.devapp.compose.wheel.example.R
import pro.devapp.compose.wheel.example.ui.theme.ComposeExampleTheme

@Composable
fun AddNewValueButton(onClick: () -> Unit) {
    val resources = LocalContext.current.resources
    FloatingActionButton(
        onClick = onClick
    ){
        Icon(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = resources.getString(R.string.add_new_values),
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExampleTheme {
        AddNewValueButton{}
    }
}