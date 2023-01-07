package com.behnawwm.stepper_compose.stepper.defaults

import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap

data class DefaultProgressLineConfiguration(
    val strokeWidth: Float,
    val pathEffect: PathEffect?,
    val cap: StrokeCap,
    val alpha: Float,
    val colorFilter: ColorFilter?,
    val blendMode: BlendMode
) : ProgressLineConfiguration {

    override fun progressLineConfiguration(): DefaultProgressLineConfiguration {
        return ProgressLineDefaults.progressLineConfiguration().progressLineConfiguration()
    }
}