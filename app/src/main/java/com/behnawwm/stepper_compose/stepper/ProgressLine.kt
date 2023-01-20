package com.behnawwm.stepper_compose.stepper

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.behnawwm.stepper_compose.stepper.config.progressLine.color.ProgressLineColors
import com.behnawwm.stepper_compose.stepper.config.progressLine.configuration.ProgressLineConfiguration
import com.behnawwm.stepper_compose.stepper.config.stepIndicator.configuration.StepIndicatorConfiguration
import com.behnawwm.stepper_compose.stepper.data.LineStatus
import com.behnawwm.stepper_compose.stepper.data.StepData

fun DrawScope.drawProgressLine(
    stepData: StepData,
    progressLineColors: ProgressLineColors,
    progressLineConfiguration: ProgressLineConfiguration,
    stepIndicatorConfiguration: StepIndicatorConfiguration
) {
    val indicatorSize = stepIndicatorConfiguration.size(stepData.progressStatus).toPx()

    val lineStartX = (indicatorSize / 2)

    val lineEndYBeforeIndicator =
        ((size.height / 2) - (indicatorSize / 2) - progressLineConfiguration.distanceFromIndicator()
            .toPx())
            .coerceAtLeast(0f)
    val lineStartYAfterIndicator =
        ((size.height / 2) + (indicatorSize / 2) + progressLineConfiguration.distanceFromIndicator()
            .toPx()).coerceAtLeast(0f)

    when (stepData.lineStatus) {
        LineStatus.End -> {
            drawTopToMiddle(
                lineStartX,
                lineEndYBeforeIndicator,
                progressLineConfiguration,
                progressLineColors.progressColor(stepData.beforeProgressStatus),
            )
        }
        LineStatus.Middle -> {
            drawTopToMiddle(
                lineStartX,
                lineEndYBeforeIndicator,
                progressLineConfiguration,
                progressLineColors.progressColor(stepData.beforeProgressStatus),
            )
            drawMiddleToBottom(
                lineStartX,
                lineStartYAfterIndicator,
                progressLineColors.progressColor(stepData.nextProgressStatus),
                progressLineConfiguration,
            )
        }
        LineStatus.Start -> {
            drawMiddleToBottom(
                lineStartX,
                lineStartYAfterIndicator,
                progressLineColors.progressColor(stepData.nextProgressStatus),
                progressLineConfiguration,
            )
        }
    }
}


fun DrawScope.drawMiddleToBottom(
    lineStartX: Float,
    lineStartAfterIndicator: Float,
    color: Color,
    progressLineConfiguration: ProgressLineConfiguration,
) {
    if (lineStartAfterIndicator >= size.height)
        return
    drawLine(
        color = color,
        start = Offset(lineStartX, lineStartAfterIndicator),
        end = Offset(lineStartX, size.height),
        strokeWidth = progressLineConfiguration.strokeWidth(),
        cap = progressLineConfiguration.cap(),
        pathEffect = progressLineConfiguration.pathEffect(),
        colorFilter = progressLineConfiguration.colorFilter(),
        blendMode = progressLineConfiguration.blendMode(),
        alpha = progressLineConfiguration.alpha(),
    )
}


fun DrawScope.drawTopToMiddle(
    lineStartX: Float,
    lineEndBeforeIndicator: Float,
    progressLineConfiguration: ProgressLineConfiguration,
    color: Color,
) {
    if (lineEndBeforeIndicator <= 0)
        return
    drawLine(
        color = color,
        start = Offset(lineStartX, 0f),
        end = Offset(lineStartX, lineEndBeforeIndicator),
        strokeWidth = progressLineConfiguration.strokeWidth(),
        cap = progressLineConfiguration.cap(),
        pathEffect = progressLineConfiguration.pathEffect(),
        colorFilter = progressLineConfiguration.colorFilter(),
        blendMode = progressLineConfiguration.blendMode(),
        alpha = progressLineConfiguration.alpha(),
    )
}