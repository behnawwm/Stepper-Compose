package com.behnawwm.stepper_compose.stepper.defaults.progressLine.configuration

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

    override fun strokeWidth(): Float {
        return strokeWidth
    }


    override fun pathEffect(): PathEffect? {
        return pathEffect
    }


    override fun cap(): StrokeCap {
        return cap
    }


    override fun alpha(): Float {
        return alpha
    }

    override fun colorFilter(): ColorFilter? {
        return colorFilter
    }

    override fun blendMode(): BlendMode {
        return blendMode
    }

}