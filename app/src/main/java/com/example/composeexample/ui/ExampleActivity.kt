package com.example.composeexample.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeexample.ui.components.wheel.WheelBox
import com.example.composeexample.ui.components.wheel.WheelItemModel
import com.example.composeexample.ui.components.wheel.WheelView
import com.example.composeexample.ui.theme.ComposeExampleTheme

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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
//                    WheelView(messages = messages)
//                    WheelView(messages = messages)
//                    WheelView(messages = messages)

//                    testRect()
//                    Text(text = "test")
//                    testRect()
//                    Text(text = "test")
//                    testRect()

                    WheelView(messages = messages)
                    WheelView(messages = messages)
                    WheelView(messages = messages, selectedIndex = 3)
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