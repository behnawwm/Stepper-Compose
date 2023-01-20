package com.behnawwm.stepper_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import com.behnawwm.stepper_compose.stepper.VerticalStepper
import com.behnawwm.stepper_compose.stepper.config.progressLine.ProgressLineDefaults
import com.behnawwm.stepper_compose.stepper.data.LineStatus
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus
import com.behnawwm.stepper_compose.stepper.data.StepData
import com.behnawwm.stepper_compose.ui.theme.SteppercomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SteppercomposeTheme {
                MainContent(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Preview
@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        VerticalStepper(
            steps = listOf(
                StepData(
                    title = "Step 1",
                    lineStatus = LineStatus.Start,
                    beforeProgressStatus = null,
                    progressStatus = ProgressStatus.Done,
                    nextProgressStatus = ProgressStatus.Done,
                ),
                StepData(
                    title = "Step 1",
                    lineStatus = LineStatus.Middle,
                    beforeProgressStatus = ProgressStatus.Done,
                    progressStatus = ProgressStatus.Done,
                    nextProgressStatus = ProgressStatus.InProgress,
                ),
                StepData(
                    title = "Step 1",
                    lineStatus = LineStatus.Middle,
                    beforeProgressStatus = ProgressStatus.InProgress,
                    progressStatus = ProgressStatus.InProgress,
                    nextProgressStatus = ProgressStatus.Remaining,
                ),
                StepData(
                    title = "Step 1",
                    lineStatus = LineStatus.End,
                    beforeProgressStatus = ProgressStatus.Remaining,
                    progressStatus = ProgressStatus.Remaining,
                    nextProgressStatus = null,
                ),
            ),
            lineProgressConfiguration = ProgressLineDefaults.progressLineConfiguration(
                strokeWidth = 5f,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 5f), 0f)
            ),
        )
    }
}
