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
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus
import com.behnawwm.stepper_compose.stepper.data.StepData
import com.behnawwm.stepper_compose.stepper.defaults.ProgressLineColors
import com.behnawwm.stepper_compose.stepper.defaults.ProgressLineConfiguration
import com.behnawwm.stepper_compose.stepper.defaults.ProgressLineDefaults

@Composable
fun Step(
    stepData: StepData,
    modifier: Modifier = Modifier,
    progressLineColors: ProgressLineColors,
    progressLineConfiguration: ProgressLineConfiguration
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .drawBehind {
                val lineStartX = (IconSize / 2)
                when (stepData.lineStatus) {
                    LineStatus.End -> {
                        drawTopToMiddle(
                            lineStartX,
                            progressLineColors.progressColor(stepData.beforeProgressStatus),
                            progressLineConfiguration
                        )
                    }
                    LineStatus.Middle -> {
                        drawTopToMiddle(
                            lineStartX,
                            progressLineColors.progressColor(stepData.beforeProgressStatus),
                            progressLineConfiguration
                        )
                        drawMiddleToBottom(
                            lineStartX,
                            progressLineColors.progressColor(stepData.nextProgressStatus),
                            progressLineConfiguration
                        )
                    }
                    LineStatus.Start -> {
                        drawMiddleToBottom(
                            lineStartX,
                            progressLineColors.progressColor(stepData.nextProgressStatus),
                            progressLineConfiguration
                        )
                    }
                }
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        StepIcon(stepData.progressStatus)
        Spacer(modifier = Modifier.width(16.dp))
        StepTitle(
            title = stepData.title,
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
        )
    }
}


private fun DrawScope.drawMiddleToBottom(
    lineStartX: Int,
    color: Color,
    progressLineConfiguration: ProgressLineConfiguration
) {
    drawLine(
        color = color,
        start = Offset(lineStartX.dp.toPx(), size.height / 2),
        end = Offset(lineStartX.dp.toPx(), size.height),
        strokeWidth = progressLineConfiguration.progressLineConfiguration().strokeWidth,
        cap = progressLineConfiguration.progressLineConfiguration().cap,
        pathEffect = progressLineConfiguration.progressLineConfiguration().pathEffect,
        colorFilter = progressLineConfiguration.progressLineConfiguration().colorFilter,
        blendMode = progressLineConfiguration.progressLineConfiguration().blendMode,
        alpha = progressLineConfiguration.progressLineConfiguration().alpha,
    )
}


private fun DrawScope.drawTopToMiddle(
    lineStartX: Int,
    color: Color,
    progressLineConfiguration: ProgressLineConfiguration
) {
    drawLine(
        color = color,
        start = Offset(lineStartX.dp.toPx(), 0f),
        end = Offset(lineStartX.dp.toPx(), size.height / 2),
        strokeWidth = 2.dp.toPx()
    )
}


@Preview
@Composable
fun StepView() {
    Step(
        StepData(
            title = "Step 1",
            lineStatus = LineStatus.Start,
            beforeProgressStatus = null,
            progressStatus = ProgressStatus.Done,
            nextProgressStatus = ProgressStatus.Done,
        ),
        progressLineColors = ProgressLineDefaults.progressLineColors(),
        progressLineConfiguration = ProgressLineDefaults.progressLineConfiguration()
    )
}

@Preview
@Composable
fun StepView2() {
    Step(
        StepData(
            title = "Step 1",
            lineStatus = LineStatus.Middle,
            beforeProgressStatus = ProgressStatus.InProgress,
            progressStatus = ProgressStatus.InProgress,
            nextProgressStatus = ProgressStatus.Remaining,
        ),
        progressLineColors = ProgressLineDefaults.progressLineColors(),
        progressLineConfiguration = ProgressLineDefaults.progressLineConfiguration()
    )
}


@Preview
@Composable
fun StepView3() {
    Step(
        StepData(
            title = "Step 1",
            lineStatus = LineStatus.End,
            beforeProgressStatus = ProgressStatus.Remaining,
            progressStatus = ProgressStatus.Remaining,
            nextProgressStatus = null,
        ),
        progressLineColors = ProgressLineDefaults.progressLineColors(),
        progressLineConfiguration = ProgressLineDefaults.progressLineConfiguration()
    )
}


