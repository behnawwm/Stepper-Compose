package com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.configuration

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

interface StepIndicatorConfiguration {

    fun shape(): Shape

    fun size(): Dp
}