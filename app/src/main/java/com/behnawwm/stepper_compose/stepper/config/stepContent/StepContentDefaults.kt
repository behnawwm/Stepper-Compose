package com.behnawwm.stepper_compose.stepper.config.stepContent

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

object StepContentDefaults {

    @Composable
    fun content(): StepContentConfiguration =
        DefaultStepContentConfiguration(
            contentComposable = { stepData, modifier ->
                Text(
                    text = stepData.title,
                    modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
            }
        )
}