package com.behnawwm.stepper_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.behnawwm.stepper_compose.stepper.data.StepData
import com.behnawwm.stepper_compose.stepper.Stepper
import com.behnawwm.stepper_compose.stepper.data.LineStatus
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus
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
//                    Stepper(
//                        steps = listOf(
//                            StepData("Step 1", LineStatus.Start, ProgressStatus.Done),
//                            StepData("Step 2", LineStatus.Middle, ProgressStatus.Done),
//                            StepData("Step 3", LineStatus.Middle, ProgressStatus.InProgress),
//                            StepData("Step 4", LineStatus.End, ProgressStatus.Remaining),
//                        ),
//                        modifier = Modifier.fillMaxSize()
//                    )
                }
            }
        }
    }
}
