package com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.color

import androidx.compose.ui.graphics.Color
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus

data class DefaultStepIndicatorColors(
    val doneColor: Color,
    val inProgressColor: Color,
    val remainingColor: Color
) : StepIndicatorColors {

    override fun indicatorColor(progressStatus: ProgressStatus?): Color {
        return when (progressStatus) {
            ProgressStatus.Done -> doneColor
            ProgressStatus.InProgress -> inProgressColor
            ProgressStatus.Remaining -> remainingColor
            null -> Color.Transparent
        }
    }

}