package com.behnawwm.stepper_compose.stepper.defaults.progressLine

import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.behnawwm.stepper_compose.stepper.defaults.progressLine.color.DefaultProgressLineColors
import com.behnawwm.stepper_compose.stepper.defaults.progressLine.color.ProgressLineColors
import com.behnawwm.stepper_compose.stepper.defaults.progressLine.configuration.DefaultProgressLineConfiguration
import com.behnawwm.stepper_compose.stepper.defaults.progressLine.configuration.ProgressLineConfiguration

object ProgressLineDefaults {

    fun progressLineColors(
        doneColor: Color = Color.Green,
        inProgressColor: Color = Color.Blue,
        remainingColor: Color = Color.Gray,
    ): ProgressLineColors = DefaultProgressLineColors(
        doneColor = doneColor,
        inProgressColor = inProgressColor,
        remainingColor = remainingColor,
    )

    fun progressLineConfiguration(
        distanceFromIndicator: Dp = 4.dp,
        strokeWidth: Float = 4f,
        pathEffect: PathEffect? = null,
        cap: StrokeCap = StrokeCap.Round,
        alpha: Float = 1.0f,
        colorFilter: ColorFilter? = null,
        blendMode: BlendMode = DrawScope.DefaultBlendMode
    ): ProgressLineConfiguration = DefaultProgressLineConfiguration(
        distanceFromIndicator = distanceFromIndicator,
        strokeWidth = strokeWidth,
        pathEffect = pathEffect,
        cap = cap,
        alpha = alpha,
        colorFilter = colorFilter,
        blendMode = blendMode
    )
}