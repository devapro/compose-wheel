package pro.devapp.compose.wheel.example.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pro.devapp.compose.wheel.WheelBox
import pro.devapp.compose.wheel.WheelItemModel
import pro.devapp.compose.wheel.WheelView
import pro.devapp.compose.wheel.example.ui.theme.ComposeExampleTheme

class ExampleActivity : ComponentActivity() {

    private val messages = listOf(
        WheelItemModel("1", 0),
        WheelItemModel("2", 1),
        WheelItemModel("3", 2),
        WheelItemModel("4", 3),
        WheelItemModel("5", 4),
        WheelItemModel("6", 5),
        WheelItemModel("7", 6),
        WheelItemModel("8", 7),
        WheelItemModel("9", 8),
        WheelItemModel("100000", 9)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        WheelView(messages = messages)
                        WheelView(messages = messages)
                        WheelView(messages = messages, selectedIndex = 3)
                    }
                }
            }
        }
    }


    @Composable
    fun testRect() {
        WheelBox (
            template = {
                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(10.dp)
                            .background(Color.Blue)
                    ) {}
                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(10.dp)
                            .background(Color.Blue)
                    ) {}
                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(10.dp)
                            .background(Color.Blue)
                    ) {}
                }
            }
                ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(10.dp)
                    .background(Color.Red)
            ) {}
        }
    }
}