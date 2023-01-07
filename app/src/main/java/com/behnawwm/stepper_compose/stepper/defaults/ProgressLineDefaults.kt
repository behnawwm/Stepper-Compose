package com.behnawwm.stepper_compose.stepper.defaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope

object ProgressLineDefaults {

    @Composable
    fun progressLineColors(
        doneColor: Color = Color.Green,
        inProgressColor: Color = Color.Blue,
        remainingColor: Color = Color.Gray,
    ): ProgressLineColors = DefaultProgressLineColors(
        doneColor = doneColor,
        inProgressColor = inProgressColor,
        remainingColor = remainingColor,
    )

    @Composable
    fun progressLineConfiguration(
        lineWidth: Float = 2f,
        pathEffect: PathEffect? = null,
        cap: StrokeCap = StrokeCap.Butt,
        alpha: Float = 1.0f,
        colorFilter: ColorFilter? = null,
        blendMode: BlendMode = DrawScope.DefaultBlendMode
    ): ProgressLineConfiguration = DefaultProgressLineConfiguration(
        lineWidth = lineWidth,
        pathEffect = pathEffect,
        cap = cap,
        alpha = alpha,
        colorFilter = colorFilter,
        blendMode = blendMode
    )
}