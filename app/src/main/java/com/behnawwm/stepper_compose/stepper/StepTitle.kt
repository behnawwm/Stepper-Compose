package com.behnawwm.stepper_compose.stepper

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun StepTitle(title: String, modifier: Modifier = Modifier) {
    Text(text = title, modifier = modifier, color = Color.Black)
}