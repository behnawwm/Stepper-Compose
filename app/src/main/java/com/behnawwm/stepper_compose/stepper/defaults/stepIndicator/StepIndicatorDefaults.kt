package com.behnawwm.stepper_compose.stepper.defaults.stepIndicator

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.color.DefaultStepIndicatorColors
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.color.StepIndicatorColors
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.configuration.DefaultStepIndicatorConfiguration
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.configuration.StepIndicatorConfiguration
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.icon.DefaultIconStepIndicatorConfiguration
import com.behnawwm.stepper_compose.stepper.defaults.stepIndicator.icon.IconStepIndicatorConfiguration

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


    @Composable
    fun iconStepIndicatorConfiguration(
        doneIconSize: Dp = 24.dp,
        inProgressIconSize: Dp = 24.dp,
        RemainingIconSize: Dp = 24.dp,
        doneIconPainter: Painter = rememberVectorPainter(image = Icons.Default.Check),
        inProgressIconPainter: Painter = rememberVectorPainter(image = Icons.Default.ArrowForward),
        remainingIconPainter: Painter = rememberVectorPainter(image = Icons.Default.Lock),
        doneIconTint: Color = Color.White,
        inProgressIconTint: Color = Color.White,
        remainingIconTint: Color = Color.White,
    ): IconStepIndicatorConfiguration = DefaultIconStepIndicatorConfiguration(
        doneIconSize = doneIconSize,
        inProgressIconSize = inProgressIconSize,
        RemainingIconSize = RemainingIconSize,
        doneIconPainter = doneIconPainter,
        inProgressIconPainter = inProgressIconPainter,
        remainingIconPainter = remainingIconPainter,
        doneIconTint = doneIconTint,
        inProgressIconTint = inProgressIconTint,
        remainingIconTint = remainingIconTint,
    )
}