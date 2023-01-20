package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.behnawwm.stepper_compose.stepper.config.progressLine.ProgressLineDefaults
import com.behnawwm.stepper_compose.stepper.config.progressLine.color.ProgressLineColors
import com.behnawwm.stepper_compose.stepper.config.progressLine.configuration.ProgressLineConfiguration
import com.behnawwm.stepper_compose.stepper.config.stepContent.StepContentConfiguration
import com.behnawwm.stepper_compose.stepper.config.stepContent.StepContentDefaults
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.StepIndicatorDefaults
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.color.StepIndicatorColors
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.configuration.StepIndicatorConfiguration
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.icon.IconStepIndicatorConfiguration
import com.behnawwm.stepper_compose.stepper.data.LineStatus
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus
import com.behnawwm.stepper_compose.stepper.data.StepData

@Composable
fun VerticalStepper(
    steps: List<StepData>,
    modifier: Modifier = Modifier,
    lineProgressColors: ProgressLineColors = ProgressLineDefaults.progressLineColors(),
    lineProgressConfiguration: ProgressLineConfiguration = ProgressLineDefaults.progressLineConfiguration(),
    stepIndicatorConfiguration: StepIndicatorConfiguration = StepIndicatorDefaults.indicatorConfiguration(),
    stepIndicatorColors: StepIndicatorColors = StepIndicatorDefaults.indicatorColors(),
    iconStepIndicatorConfiguration: IconStepIndicatorConfiguration = StepIndicatorDefaults.iconStepIndicatorConfiguration(),
    stepContentConfiguration: StepContentConfiguration = StepContentDefaults.content()
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        items(steps) { stepData ->
            Step(
                stepData = stepData,
                modifier = Modifier.fillMaxWidth(),
                progressLineColors = lineProgressColors,
                progressLineConfiguration = lineProgressConfiguration,
                stepIndicatorConfiguration = stepIndicatorConfiguration,
                stepIndicatorColors = stepIndicatorColors,
                iconStepIndicatorConfiguration = iconStepIndicatorConfiguration,
                content = stepContentConfiguration.content(stepData = stepData, modifier = Modifier)
            )
        }
    }
}

@Preview
@Composable
fun StepperPreview() {
    VerticalStepper(
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
                progressStatus = ProgressStatus.Remaining,
                nextProgressStatus = null,
            ),
        )
    )
}