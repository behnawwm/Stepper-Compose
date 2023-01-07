package com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.configuration

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus

interface StepIndicatorConfiguration {

    fun shape(progressStatus: ProgressStatus): Shape

    fun size(progressStatus: ProgressStatus): Dp
}