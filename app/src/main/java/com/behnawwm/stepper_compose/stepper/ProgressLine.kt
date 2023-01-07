package com.behnawwm.stepper_compose.stepper

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import com.behnawwm.stepper_compose.stepper.data.LineStatus
import com.behnawwm.stepper_compose.stepper.data.StepData
import com.behnawwm.stepper_compose.stepper.defaults.progressLine.color.ProgressLineColors
import com.behnawwm.stepper_compose.stepper.defaults.progressLine.configuration.ProgressLineConfiguration
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.configuration.StepIndicatorConfiguration

fun DrawScope.drawProgressLine(
    stepData: StepData,
    progressLineColors: ProgressLineColors,
    progressLineConfiguration: ProgressLineConfiguration,
    stepIndicatorConfiguration: StepIndicatorConfiguration
) {
    val lineStartX = (stepIndicatorConfiguration.size() / 2)
    when (stepData.lineStatus) {
        LineStatus.End -> {
            drawTopToMiddle(
                lineStartX,
                progressLineColors.progressColor(stepData.beforeProgressStatus),
                progressLineConfiguration
            )
        }
        LineStatus.Middle -> {
            drawTopToMiddle(
                lineStartX,
                progressLineColors.progressColor(stepData.beforeProgressStatus),
                progressLineConfiguration
            )
            drawMiddleToBottom(
                lineStartX,
                progressLineColors.progressColor(stepData.nextProgressStatus),
                progressLineConfiguration
            )
        }
        LineStatus.Start -> {
            drawMiddleToBottom(
                lineStartX,
                progressLineColors.progressColor(stepData.nextProgressStatus),
                progressLineConfiguration
            )
        }
    }
}


fun DrawScope.drawMiddleToBottom(
    lineStartX: Dp,
    color: Color,
    progressLineConfiguration: ProgressLineConfiguration
) {
    drawLine(
        color = color,
        start = Offset(lineStartX.toPx(), size.height / 2),
        end = Offset(lineStartX.toPx(), size.height),
        strokeWidth = progressLineConfiguration.strokeWidth(),
        cap = progressLineConfiguration.cap(),
        pathEffect = progressLineConfiguration.pathEffect(),
        colorFilter = progressLineConfiguration.colorFilter(),
        blendMode = progressLineConfiguration.blendMode(),
        alpha = progressLineConfiguration.alpha(),
    )
}


fun DrawScope.drawTopToMiddle(
    lineStartX: Dp,
    color: Color,
    progressLineConfiguration: ProgressLineConfiguration
) {
    drawLine(
        color = color,
        start = Offset(lineStartX.toPx(), 0f),
        end = Offset(lineStartX.toPx(), size.height / 2),
        strokeWidth = progressLineConfiguration.strokeWidth()
    )
}