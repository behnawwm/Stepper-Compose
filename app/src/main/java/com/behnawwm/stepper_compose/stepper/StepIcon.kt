package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus

@Composable
fun StepIcon(progressStatus: ProgressStatus) {
    when (progressStatus) {
        is ProgressStatus.Done -> DoneStepIcon()
        is ProgressStatus.InProgress -> InProgressStepIcon()
        is ProgressStatus.Remaining -> RemainingStepIcon()
    }
}

@Composable
fun DoneStepIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(IconSize.dp)
            .clip(CircleShape)
            .background(Color.Green)
    )
}

@Composable
fun InProgressStepIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(IconSize.dp)
            .clip(CircleShape)
            .background(Color.Blue)
    )
}

@Composable
fun RemainingStepIcon(modifier: Modifier = Modifier) {
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
    Column {
        StepIcon(ProgressStatus.Done)
        StepIcon(ProgressStatus.InProgress)
        StepIcon(ProgressStatus.Remaining)
    }
}
