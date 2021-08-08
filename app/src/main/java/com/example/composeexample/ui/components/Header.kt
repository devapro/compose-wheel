package com.example.composeexample.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Header(title: String) {
    Text(text = title, style = MaterialTheme.typography.h3)
}