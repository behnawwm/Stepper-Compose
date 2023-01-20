package com.behnawwm.stepper_compose.stepper.config.stepIndicator.configuration

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus

data class DefaultStepIndicatorConfiguration(
    val size: Dp,
    val shape: Shape
) : StepIndicatorConfiguration {

    override fun shape(progressStatus: ProgressStatus): Shape {
        return shape    //todo DO IT
    }

    override fun size(progressStatus: ProgressStatus): Dp {
        return size
    }

}