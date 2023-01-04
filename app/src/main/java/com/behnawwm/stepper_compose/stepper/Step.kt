package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.behnawwm.stepper_compose.stepper.data.Constants.IconSize
import com.behnawwm.stepper_compose.stepper.data.LineStatus
import com.behnawwm.stepper_compose.stepper.data.StepData

@Composable
fun Step(
    stepData: StepData,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .drawBehind {
                val lineStartX = (IconSize / 2)
                when (stepData.lineStatus) {
                    LineStatus.End -> {
                        drawEndLine(lineStartX)
                    }
                    LineStatus.Middle -> {
                        drawStartLine(lineStartX)
                        drawEndLine(lineStartX)
                    }
                    LineStatus.Start -> {
                        drawStartLine(lineStartX)
                    }
                }
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        StepIcon(stepData.lineStatus)
        Spacer(modifier = Modifier.width(16.dp))
        StepTitle(
            title = stepData.title,
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
        )
    }
}


private fun DrawScope.drawStartLine(lineStartX: Int) {
    drawLine(
        color = Color.Green,
        start = Offset(lineStartX.dp.toPx(), size.height / 2),
        end = Offset(lineStartX.dp.toPx(), size.height),
        strokeWidth = 2.dp.toPx()
    )
}

private fun DrawScope.drawEndLine(lineStartX: Int) {
    drawLine(
        color = Color.Green,
        start = Offset(lineStartX.dp.toPx(), 0f),
        end = Offset(lineStartX.dp.toPx(), size.height / 2),
        strokeWidth = 2.dp.toPx()
    )
}


@Preview
@Composable
fun StepView() {
    Step(StepData("Step 1", LineStatus.Start))
}

@Preview
@Composable
fun StepView2() {
    Step(StepData("Step 1", LineStatus.Middle))
}


@Preview
@Composable
fun StepView3() {
    Step(StepData("Step 1", LineStatus.End))
}


