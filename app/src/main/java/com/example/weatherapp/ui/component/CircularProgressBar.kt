package com.example.weatherapp.ui.component

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun CircularProgressBar(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier,
        color = MaterialTheme.colors.secondaryVariant,
        strokeWidth = 5.dp
    )
}