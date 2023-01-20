package com.behnawwm.stepper_compose.stepper.config.stepContent

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.behnawwm.stepper_compose.stepper.data.StepData

interface StepContentConfiguration {

    @Composable
    fun content(stepData: StepData, modifier: Modifier): @Composable () -> Unit
}