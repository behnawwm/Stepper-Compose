package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.behnawwm.stepper_compose.stepper.data.LineStatus
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus
import com.behnawwm.stepper_compose.stepper.data.StepData

@Composable
fun Stepper(
    steps: List<StepData>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(steps.size) { index ->
            Step(
                stepData = steps[index],
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}


@Preview
@Composable
fun StepperPreview() {
    Stepper(
        listOf(
            StepData(
                title = "Step 1",
                lineStatus = LineStatus.Start,
                beforeProgressStatus = null,
                progressStatus = ProgressStatus.Done,
                nextProgressStatus = ProgressStatus.Done,
            ),
            StepData(
                title = "Step 1",
                lineStatus = LineStatus.Middle,
                beforeProgressStatus = ProgressStatus.Done,
                progressStatus = ProgressStatus.Done,
                nextProgressStatus = ProgressStatus.InProgress,
            ),
            StepData(
                title = "Step 1",
                lineStatus = LineStatus.Middle,
                beforeProgressStatus = ProgressStatus.InProgress,
                progressStatus = ProgressStatus.InProgress,
                nextProgressStatus = ProgressStatus.Remaining,
            ),
            StepData(
                title = "Step 1",
                lineStatus = LineStatus.End,
                beforeProgressStatus = ProgressStatus.Remaining,
                progressStatus = ProgressStatus.Done,
                nextProgressStatus = null,
            ),
        )
    )
}