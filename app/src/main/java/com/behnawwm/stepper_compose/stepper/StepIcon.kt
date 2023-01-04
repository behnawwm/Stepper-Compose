package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.behnawwm.stepper_compose.stepper.data.Constants.IconSize
import com.behnawwm.stepper_compose.stepper.data.LineStatus

@Composable
fun StepIcon(lineStatus: LineStatus) {
    when (lineStatus) {
        LineStatus.End -> StepIconInactive()
        LineStatus.Middle -> StepIconActive()
        LineStatus.Start -> StepIconActive()
    }
}

@Composable
fun StepIconActive(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(IconSize.dp)
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
    StepIcon(LineStatus.Start)
}
