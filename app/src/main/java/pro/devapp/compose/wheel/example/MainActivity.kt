package pro.devapp.compose.wheel.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pro.devapp.compose.wheel.example.ui.components.AddNewValueButton
import pro.devapp.compose.wheel.example.ui.components.FullWidthTextField
import pro.devapp.compose.wheel.example.ui.components.Header
import pro.devapp.compose.wheel.example.ui.components.MainButton
import pro.devapp.compose.wheel.example.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                //mainScreen()
                addNewValueForm()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun addNewValueForm() {
    Scaffold(
        floatingActionButton = {AddNewValueButton{}}
    ) {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.padding(Dp(16.0f), Dp(16.0f))
        ) {
            Column {
                Header("Title")
                Spacer(modifier = Modifier.height(4.dp))
                FullWidthTextField("Label test")
                Spacer(modifier = Modifier.height(4.dp))
                FullWidthTextField("Label")
                Spacer(modifier = Modifier.height(4.dp))
                FullWidthTextField("Label")
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                ) {
                    MainButton()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun mainScreen() {
    Scaffold(
        floatingActionButton = {AddNewValueButton{}}
    ) {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.padding(Dp(16.0f), Dp(16.0f))
        ) {
            Header("Dialog title")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExampleTheme {
        Header("Android")
        AddNewValueButton{}
    }
}