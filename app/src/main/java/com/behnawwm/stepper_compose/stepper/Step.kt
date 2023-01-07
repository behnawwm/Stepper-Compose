package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.behnawwm.stepper_compose.stepper.data.LineStatus
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus
import com.behnawwm.stepper_compose.stepper.data.StepData
import com.behnawwm.stepper_compose.stepper.defaults.progressLine.ProgressLineDefaults
import com.behnawwm.stepper_compose.stepper.defaults.progressLine.color.ProgressLineColors
import com.behnawwm.stepper_compose.stepper.defaults.progressLine.configuration.ProgressLineConfiguration
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.StepIndicatorDefaults
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.color.StepIndicatorColors
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.configuration.StepIndicatorConfiguration
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.icon.IconStepIndicatorConfiguration

@Composable
fun Step(
    stepData: StepData,
    progressLineColors: ProgressLineColors,
    progressLineConfiguration: ProgressLineConfiguration,
    stepIndicatorConfiguration: StepIndicatorConfiguration,
    stepIndicatorColors: StepIndicatorColors,
    iconStepIndicatorConfiguration: IconStepIndicatorConfiguration,
    modifier: Modifier = Modifier,
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
        Spacer(modifier = Modifier.width(16.dp))
        StepTitle(
            title = stepData.title,
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
        )
    }
}


@Preview
@Composable
fun StepView() {
    Step(
        StepData(
            title = "Step 1",
            lineStatus = LineStatus.Start,
            beforeProgressStatus = null,
            progressStatus = ProgressStatus.Done,
            nextProgressStatus = ProgressStatus.Done,
        ),
        progressLineColors = ProgressLineDefaults.progressLineColors(),
        progressLineConfiguration = ProgressLineDefaults.progressLineConfiguration(),
        stepIndicatorConfiguration = StepIndicatorDefaults.indicatorConfiguration(),
        stepIndicatorColors = StepIndicatorDefaults.indicatorColors(),
        iconStepIndicatorConfiguration = StepIndicatorDefaults.iconStepIndicatorConfiguration(),
    )
}

@Preview
@Composable
fun StepView2() {
    Step(
        StepData(
            title = "Step 1",
            lineStatus = LineStatus.Middle,
            beforeProgressStatus = ProgressStatus.InProgress,
            progressStatus = ProgressStatus.InProgress,
            nextProgressStatus = ProgressStatus.Remaining,
        ),
        progressLineColors = ProgressLineDefaults.progressLineColors(),
        progressLineConfiguration = ProgressLineDefaults.progressLineConfiguration(),
        stepIndicatorConfiguration = StepIndicatorDefaults.indicatorConfiguration(),
        stepIndicatorColors = StepIndicatorDefaults.indicatorColors(),
        iconStepIndicatorConfiguration = StepIndicatorDefaults.iconStepIndicatorConfiguration(),
    )
}


@Preview
@Composable
fun StepView3() {
    Step(
        StepData(
            title = "Step 1",
            lineStatus = LineStatus.End,
            beforeProgressStatus = ProgressStatus.Remaining,
            progressStatus = ProgressStatus.Remaining,
            nextProgressStatus = null,
        ),
        progressLineColors = ProgressLineDefaults.progressLineColors(),
        progressLineConfiguration = ProgressLineDefaults.progressLineConfiguration(),
        stepIndicatorConfiguration = StepIndicatorDefaults.indicatorConfiguration(),
        stepIndicatorColors = StepIndicatorDefaults.indicatorColors(),
        iconStepIndicatorConfiguration = StepIndicatorDefaults.iconStepIndicatorConfiguration(),
    )
}


