package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.behnawwm.stepper.StepData

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
                    .height(80.dp)
            )
        }
    }
}

@Composable
fun Test(modifier: Modifier = Modifier, stepData: StepData) {
    Box(
        modifier = modifier
            .background(Color.LightGray)
    ) {
        Step(stepData = stepData)
    }
}


@Preview
@Composable
fun StepperPreview() {
    Stepper(
        listOf(
            StepData("Step 1", 0),
            StepData("Step 2", 0),
            StepData("Step 3", 0),
            StepData("Step 4", 1),
        )
    )
}