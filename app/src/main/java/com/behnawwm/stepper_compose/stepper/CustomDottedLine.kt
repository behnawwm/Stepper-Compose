//package com.behnawwm.stepper
//
//import androidx.compose.foundation.Canvas
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.PathEffect
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun CustomDottedLine(modifier: Modifier, spacerHeight: Dp = 3.dp) {
//    Canvas(modifier = modifier) {
//        //vertical
//        drawLine(
//            color = black,
//            start = Offset(0f, size.height / 4),
//            end = Offset(0f, size.height * 3 / 4 + spacerHeight.toPx()),
//            strokeWidth = 1.dp.toPx(),
//            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
//        )
//        //horizontal 1
//        drawLine(
//            color = gray,
//            start = Offset(0f, size.height / 4),
//            end = Offset(size.width, size.height / 4),
//            strokeWidth = 1.dp.toPx(),
//            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
//        )
//        //horizontal 2
//        drawLine(
//            color = gray,
//            start = Offset(0f, size.height * 3 / 4 + spacerHeight.toPx()),
//            end = Offset(size.width, size.height * 3 / 4 + spacerHeight.toPx()),
//            strokeWidth = 1.dp.toPx(),
//            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
//        )
//    }
//}