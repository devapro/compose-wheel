package pro.devapp.compose.wheel.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import pro.devapp.compose.wheel.example.ui.theme.TextFieldLabelStyle
import pro.devapp.compose.wheel.example.ui.theme.TextFieldTextStyle

// TODO
// change bottom border color after focus
// set and get value
// show errors
// set title

@Composable
fun FullWidthTextField(label: String) {
    var state = rememberSaveable(saver = TextFieldValue.Saver) { TextFieldValue() }
    val focusState = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        BasicTextField(
            value = state,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    focusState.value = it.hasFocus
                },
            onValueChange = {
                state = it
            },
            keyboardActions = KeyboardActions {

            },
            textStyle = TextFieldTextStyle,
            decorationBox = {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(label, style = TextFieldLabelStyle)
                    Box(modifier = Modifier.padding(vertical = Dp(4F))) {
                        it()
                        if (!focusState.value) {
                            Text(text = "Placeholder", style = TextFieldTextStyle)
                        }
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(Dp(1F))
                            .background(color = MaterialTheme.colors.primary)
                    )
                }
            }
        )
    }
}