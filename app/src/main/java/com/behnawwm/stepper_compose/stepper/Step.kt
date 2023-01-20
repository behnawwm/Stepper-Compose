package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.tooling.preview.Preview
import com.behnawwm.stepper_compose.stepper.config.progressLine.ProgressLineDefaults
import com.behnawwm.stepper_compose.stepper.config.progressLine.color.ProgressLineColors
import com.behnawwm.stepper_compose.stepper.config.progressLine.configuration.ProgressLineConfiguration
import com.behnawwm.stepper_compose.stepper.config.stepContent.StepContentDefaults
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.StepIndicatorDefaults
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.color.StepIndicatorColors
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.configuration.StepIndicatorConfiguration
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.icon.IconStepIndicatorConfiguration
import com.behnawwm.stepper_compose.stepper.data.LineStatus
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus
import com.behnawwm.stepper_compose.stepper.data.StepData

@Composable
fun Step(
    stepData: StepData,
    progressLineColors: ProgressLineColors,
    progressLineConfiguration: ProgressLineConfiguration,
    stepIndicatorConfiguration: StepIndicatorConfiguration,
    stepIndicatorColors: StepIndicatorColors,
    iconStepIndicatorConfiguration: IconStepIndicatorConfiguration,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .drawBehind {
                drawProgressLine(
                    stepData,
                    progressLineColors,
                    progressLineConfiguration,
                    stepIndicatorConfiguration
                )
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconStepIndicator(
            stepData,
            stepIndicatorColors,
            stepIndicatorConfiguration,
            iconStepIndicatorConfiguration
        )
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            content()
        }
    }
}


@Preview
@Composable
fun StepView() {
    val stepData = StepData(
        title = "Step 1",
        lineStatus = LineStatus.Start,
        beforeProgressStatus = null,
        progressStatus = ProgressStatus.Done,
        nextProgressStatus = ProgressStatus.Done,
    )
    Step(
        stepData = stepData,
        progressLineColors = ProgressLineDefaults.progressLineColors(),
        progressLineConfiguration = ProgressLineDefaults.progressLineConfiguration(),
        stepIndicatorConfiguration = StepIndicatorDefaults.indicatorConfiguration(),
        stepIndicatorColors = StepIndicatorDefaults.indicatorColors(),
        iconStepIndicatorConfiguration = StepIndicatorDefaults.iconStepIndicatorConfiguration(),
        content = { StepContentDefaults.content() }
    )
}

@Preview
@Composable
fun StepView2() {
    val stepData = StepData(
        title = "Step 1",
        lineStatus = LineStatus.Middle,
        beforeProgressStatus = ProgressStatus.InProgress,
        progressStatus = ProgressStatus.InProgress,
        nextProgressStatus = ProgressStatus.Remaining,
    )
    Step(
        stepData = stepData,
        progressLineColors = ProgressLineDefaults.progressLineColors(),
        progressLineConfiguration = ProgressLineDefaults.progressLineConfiguration(),
        stepIndicatorConfiguration = StepIndicatorDefaults.indicatorConfiguration(),
        stepIndicatorColors = StepIndicatorDefaults.indicatorColors(),
        iconStepIndicatorConfiguration = StepIndicatorDefaults.iconStepIndicatorConfiguration(),
        content = { StepContentDefaults.content() }
    )
}


@Preview
@Composable
fun StepView3() {
    val stepData = StepData(
        title = "Step 1",
        lineStatus = LineStatus.End,
        beforeProgressStatus = ProgressStatus.Remaining,
        progressStatus = ProgressStatus.Remaining,
        nextProgressStatus = null,
    )
    Step(
        stepData = stepData,
        progressLineColors = ProgressLineDefaults.progressLineColors(),
        progressLineConfiguration = ProgressLineDefaults.progressLineConfiguration(),
        stepIndicatorConfiguration = StepIndicatorDefaults.indicatorConfiguration(),
        stepIndicatorColors = StepIndicatorDefaults.indicatorColors(),
        iconStepIndicatorConfiguration = StepIndicatorDefaults.iconStepIndicatorConfiguration(),
        content = { StepContentDefaults.content() }
    )
}


