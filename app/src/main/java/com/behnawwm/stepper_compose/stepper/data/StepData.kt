package com.behnawwm.stepper_compose.stepper.data

data class StepData(
    val title: String,
    val lineStatus: LineStatus,
    val progressStatus : ProgressStatus,
    val nextProgressStatus : ProgressStatus?,
    val beforeProgressStatus : ProgressStatus?,
)
