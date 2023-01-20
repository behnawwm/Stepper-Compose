package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.StepIndicatorDefaults
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.color.StepIndicatorColors
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.configuration.StepIndicatorConfiguration
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.icon.IconStepIndicatorConfiguration
import com.behnawwm.stepper_compose.stepper.data.LineStatus
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus
import com.behnawwm.stepper_compose.stepper.data.StepData

@Composable
fun IconStepIndicator(
    stepData: StepData,
    stepIndicatorColors: StepIndicatorColors,
    stepIndicatorConfiguration: StepIndicatorConfiguration,
    iconStepIndicatorConfiguration: IconStepIndicatorConfiguration,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(stepIndicatorConfiguration.size(stepData.progressStatus))
            .clip(stepIndicatorConfiguration.shape(stepData.progressStatus))
            .background(stepIndicatorColors.indicatorColor(stepData.progressStatus))
    ) {
        Icon(
            painter = iconStepIndicatorConfiguration.iconPainter(stepData.progressStatus),
            contentDescription = null,
            tint = iconStepIndicatorConfiguration.iconTint(stepData.progressStatus),
            modifier = Modifier
                .size(iconStepIndicatorConfiguration.iconSize(stepData.progressStatus))
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun StepIndicatorPreview() {
    IconStepIndicator(
        stepData = StepData(
            "Step 1",
            LineStatus.Start,
            ProgressStatus.Done,
            beforeProgressStatus = ProgressStatus.Done,
            nextProgressStatus = ProgressStatus.Remaining
        ),
        stepIndicatorColors = StepIndicatorDefaults.indicatorColors(),
        stepIndicatorConfiguration = StepIndicatorDefaults.indicatorConfiguration(),
        iconStepIndicatorConfiguration = StepIndicatorDefaults.iconStepIndicatorConfiguration(),
    )
}

@Preview
@Composable
fun StepIndicatorPreview2() {
    IconStepIndicator(
        stepData = StepData(
            "Step 1",
            LineStatus.Start,
            ProgressStatus.InProgress,
            beforeProgressStatus = ProgressStatus.Done,
            nextProgressStatus = ProgressStatus.Remaining
        ),
        stepIndicatorColors = StepIndicatorDefaults.indicatorColors(),
        stepIndicatorConfiguration = StepIndicatorDefaults.indicatorConfiguration(),
        iconStepIndicatorConfiguration = StepIndicatorDefaults.iconStepIndicatorConfiguration(),
    )
}

@Preview
@Composable
fun StepIndicatorPreview3() {
    IconStepIndicator(
        stepData = StepData(
            "Step 1",
            LineStatus.Start,
            ProgressStatus.Remaining,
            beforeProgressStatus = ProgressStatus.Done,
            nextProgressStatus = ProgressStatus.Remaining
        ),
        stepIndicatorColors = StepIndicatorDefaults.indicatorColors(),
        stepIndicatorConfiguration = StepIndicatorDefaults.indicatorConfiguration(),
        iconStepIndicatorConfiguration = StepIndicatorDefaults.iconStepIndicatorConfiguration(),
    )
}