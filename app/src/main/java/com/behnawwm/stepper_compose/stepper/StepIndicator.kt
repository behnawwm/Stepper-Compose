package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.behnawwm.stepper_compose.stepper.data.LineStatus
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus
import com.behnawwm.stepper_compose.stepper.data.StepData
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.StepIndicatorDefaults
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.color.StepIndicatorColors
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.configuration.StepIndicatorConfiguration

@Composable
fun StepIndicator(
    stepData: StepData,
    stepIndicatorColors: StepIndicatorColors,
    stepIndicatorConfiguration: StepIndicatorConfiguration,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(stepIndicatorConfiguration.size())
            .clip(stepIndicatorConfiguration.shape())
            .background(stepIndicatorColors.indicatorColor(stepData.progressStatus))
    )
}

@Preview
@Composable
fun StepIndicatorPreview() {
    StepIndicator(
        stepData = StepData(
            "Step 1",
            LineStatus.Start,
            ProgressStatus.InProgress,
            beforeProgressStatus = ProgressStatus.Done,
            nextProgressStatus = ProgressStatus.Remaining
        ),
        stepIndicatorColors = StepIndicatorDefaults.indicatorColors(),
        stepIndicatorConfiguration = StepIndicatorDefaults.indicatorConfiguration(),
    )
}