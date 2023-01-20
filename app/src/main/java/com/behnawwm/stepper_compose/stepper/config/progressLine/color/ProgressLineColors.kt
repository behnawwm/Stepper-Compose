package com.behnawwm.stepper_compose.stepper.config.progressLine.color

import androidx.compose.ui.graphics.Color
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus

interface ProgressLineColors {

    fun progressColor(progressStatus: ProgressStatus?): Color //todo migrate to state?
}