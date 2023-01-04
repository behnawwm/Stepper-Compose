package com.behnawwm.stepper_compose.stepper

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.behnawwm.stepper_compose.stepper.data.Constants.IconSize
import com.behnawwm.stepper_compose.stepper.data.LineStatus
import com.behnawwm.stepper_compose.stepper.data.ProgressStatus
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
                        drawTopToMiddle(lineStartX, stepData.beforeProgressStatus)
                    }
                    LineStatus.Middle -> {
                        drawTopToMiddle(lineStartX, stepData.beforeProgressStatus)
                        drawMiddleToBottom(lineStartX, stepData.nextProgressStatus)
                    }
                    LineStatus.Start -> {
                        drawMiddleToBottom(lineStartX, stepData.nextProgressStatus)
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


private fun DrawScope.drawMiddleToBottom(lineStartX: Int, nextProgressStatus: ProgressStatus?) {
    when (nextProgressStatus) {
        ProgressStatus.Done -> drawMiddleToBottom(lineStartX, Color.Green)
        ProgressStatus.InProgress -> drawMiddleToBottom(lineStartX, Color.Blue)
        ProgressStatus.Remaining -> drawMiddleToBottom(lineStartX, Color.Gray)
        null -> {}
    }
}

private fun DrawScope.drawMiddleToBottom(lineStartX: Int, color: Color) {
    drawLine(
        color = color,
        start = Offset(lineStartX.dp.toPx(), size.height / 2),
        end = Offset(lineStartX.dp.toPx(), size.height),
        strokeWidth = 2.dp.toPx()
    )
}

private fun DrawScope.drawTopToMiddle(lineStartX: Int, beforeProgressStatus: ProgressStatus?) {
    when (beforeProgressStatus) {
        ProgressStatus.Done -> drawTopToMiddle(lineStartX, Color.Green)
        ProgressStatus.InProgress -> drawTopToMiddle(lineStartX, Color.Blue)
        ProgressStatus.Remaining -> drawTopToMiddle(lineStartX, Color.Gray)
        null -> {}
    }
}

private fun DrawScope.drawTopToMiddle(lineStartX: Int, color: Color) {
    drawLine(
        color = color,
        start = Offset(lineStartX.dp.toPx(), 0f),
        end = Offset(lineStartX.dp.toPx(), size.height / 2),
        strokeWidth = 2.dp.toPx()
    )
}


//@Preview
//@Composable
//fun StepView() {
//    Step(
//        StepData("Step 1", LineStatus.Start, ProgressStatus.Done,)
//    )
//}
//
//@Preview
//@Composable
//fun StepView2() {
//    Step(StepData("Step 1", LineStatus.Middle, ProgressStatus.InProgress))
//}
//
//
//@Preview
//@Composable
//fun StepView3() {
//    Step(StepData("Step 1", LineStatus.End, ProgressStatus.Remaining))
//}
//
//
