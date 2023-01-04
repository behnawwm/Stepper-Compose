package com.behnawwm.stepper_compose.stepper.data

sealed interface LineStatus{
    object Start : LineStatus
    object Middle : LineStatus
    object End : LineStatus
}