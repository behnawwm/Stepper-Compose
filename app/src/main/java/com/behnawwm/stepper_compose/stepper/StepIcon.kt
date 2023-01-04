package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StepIcon(type: Int) {
    when (type) {
        0 -> StepIconActive()
        1 -> StepIconInactive()
    }
}

@Composable
fun StepIconActive(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(Color.Green)
    )
}

@Composable
fun StepIconInactive(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(Color.Gray)
    )
}


@Preview
@Composable
fun StepIconPreview() {
    StepIcon(0)
}

@Preview
@Composable
fun StepIconPreview2() {
    StepIcon(1)
}