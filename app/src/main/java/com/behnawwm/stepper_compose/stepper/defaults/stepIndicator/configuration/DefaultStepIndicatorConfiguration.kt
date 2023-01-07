package com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.configuration

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

data class DefaultStepIndicatorConfiguration(
    val size: Dp,
    val shape: Shape
) : StepIndicatorConfiguration {

    override fun shape(): Shape {
        return shape
    }

    override fun size(): Dp {
        return size
    }

}