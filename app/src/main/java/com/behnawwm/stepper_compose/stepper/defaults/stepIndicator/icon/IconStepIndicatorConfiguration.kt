package com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus

interface IconStepIndicatorConfiguration {

    fun iconSize(progressStatus: ProgressStatus): Dp

    fun iconPainter(progressStatus: ProgressStatus): Painter

    fun iconTint(progressStatus: ProgressStatus): Color
}