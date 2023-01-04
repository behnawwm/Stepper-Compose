package com.behnawwm.stepper_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.behnawwm.stepper.StepData
import com.behnawwm.stepper_compose.stepper.Stepper
import com.behnawwm.stepper_compose.ui.theme.SteppercomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SteppercomposeTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                ) {
                    Stepper(
                        steps = listOf(
                            StepData("Step 1", 0),
                            StepData("Step 2", 0),
                            StepData("Step 3", 0),
                            StepData("Step 4", 1),
                        ),
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
