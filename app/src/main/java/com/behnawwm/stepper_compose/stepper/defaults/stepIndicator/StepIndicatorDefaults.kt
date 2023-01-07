package com.behnawwm.stepper_compose.stepper.defaults.stepIndicator

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.color.DefaultStepIndicatorColors
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.color.StepIndicatorColors
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.configuration.DefaultStepIndicatorConfiguration
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.configuration.StepIndicatorConfiguration

object StepIndicatorDefaults {

    fun indicatorColors(
        doneColor: Color = Color.Green,
        inProgressColor: Color = Color.Blue,
        remainingColor: Color = Color.Gray,
    ): StepIndicatorColors = DefaultStepIndicatorColors(
        doneColor = doneColor,
        inProgressColor = inProgressColor,
        remainingColor = remainingColor,
    )

    fun indicatorConfiguration(
        size: Dp = 48.dp,
        shape: Shape = CircleShape,
    ): StepIndicatorConfiguration = DefaultStepIndicatorConfiguration(
        size = size,
        shape = shape,
    )
}