package com.example.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composeexample.ui.components.AddNewValueButton
import com.example.composeexample.ui.components.FullWidthTextField
import com.example.composeexample.ui.components.Header
import com.example.composeexample.ui.components.MainButton
import com.example.composeexample.ui.theme.ComposeExampleTheme

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