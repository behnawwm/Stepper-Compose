package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.behnawwm.stepper.StepData

@Composable
fun Step(
    stepData: StepData,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        StepIcon(stepData.type)
        Spacer(modifier = Modifier.width(16.dp))
        StepTitle(
            title = stepData.title,
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Preview
@Composable
fun StepView() {
    Step(StepData("Step 1", 0))
}

@Preview
@Composable
fun StepView2() {
    Step(StepData("Step 1", 1))
}



