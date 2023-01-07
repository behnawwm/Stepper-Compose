package com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus

data class DefaultIconStepIndicatorConfiguration(
    val doneIconSize: Dp,
    val inProgressIconSize: Dp,
    val RemainingIconSize: Dp,
    val doneIconPainter: Painter,
    val inProgressIconPainter: Painter,
    val remainingIconPainter: Painter,
    val doneIconTint: Color,
    val inProgressIconTint: Color,
    val remainingIconTint: Color,
) : IconStepIndicatorConfiguration {

    override fun iconSize(progressStatus: ProgressStatus): Dp {
        return when (progressStatus) {
            ProgressStatus.Done -> doneIconSize
            ProgressStatus.InProgress -> inProgressIconSize
            ProgressStatus.Remaining -> RemainingIconSize
        }
    }

    override fun iconPainter(progressStatus: ProgressStatus): Painter {
        return when (progressStatus) {
            ProgressStatus.Done -> doneIconPainter
            ProgressStatus.InProgress -> inProgressIconPainter
            ProgressStatus.Remaining -> remainingIconPainter
        }
    }

    override fun iconTint(progressStatus: ProgressStatus): Color {
        return when (progressStatus) {
            ProgressStatus.Done -> doneIconTint
            ProgressStatus.InProgress -> inProgressIconTint
            ProgressStatus.Remaining -> remainingIconTint
        }
    }

}
