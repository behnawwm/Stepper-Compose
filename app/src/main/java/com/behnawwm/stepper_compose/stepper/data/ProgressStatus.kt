package com.behnawwm.stepper_compose.stepper.data

sealed interface ProgressStatus {
    object Done : ProgressStatus
    object InProgress : ProgressStatus
    object Remaining : ProgressStatus
}