package com.behnawwm.stepper_compose.stepper.config.stepContent

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.behnawwm.stepper_compose.stepper.data.StepData

class DefaultStepContentConfiguration(
    val contentComposable: @Composable (stepData: StepData, modifier: Modifier) -> Unit,
) : StepContentConfiguration {

    @Composable
    override fun content(stepData: StepData, modifier: Modifier): @Composable () -> Unit {
        return { contentComposable(stepData, modifier) }
    }
}