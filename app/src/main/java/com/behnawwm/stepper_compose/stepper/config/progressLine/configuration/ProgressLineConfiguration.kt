package com.behnawwm.stepper_compose.stepper.config.progressLine.configuration

import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp

interface ProgressLineConfiguration {   //todo migrate values to value states

    fun distanceFromIndicator(): Dp

    fun strokeWidth(): Float

    fun pathEffect(): PathEffect?

    fun cap(): StrokeCap

    fun alpha(): Float

    fun colorFilter(): ColorFilter?

    fun blendMode(): BlendMode
}