package com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.color

import androidx.compose.ui.graphics.Color
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus

interface StepIndicatorColors {

    fun indicatorColor(progressStatus: ProgressStatus?): Color //todo migrate to state?
}