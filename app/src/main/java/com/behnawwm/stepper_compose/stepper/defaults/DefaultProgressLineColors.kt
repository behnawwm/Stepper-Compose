package com.behnawwm.stepper_compose.stepper.defaults

import androidx.compose.ui.graphics.Color
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus

data class DefaultProgressLineColors(
    val doneColor: Color,
    val inProgressColor: Color,
    val remainingColor: Color
) : ProgressLineColors {

    override fun progressColor(progressStatus: ProgressStatus?): Color {
        return when (progressStatus) {
            ProgressStatus.Done -> doneColor
            ProgressStatus.InProgress -> inProgressColor
            ProgressStatus.Remaining -> remainingColor
            null -> Color.Transparent
        }
        //todo use rememberUpdatedState
    }
}