package com.lotto24.qacase.domain.model

data class LottoDomain(
    val lottery: String,
    val lastDrawDate: String,
    val numbers: List<Int>,
    val superNumber: List<Int>,
    val isEuroJackpot: Boolean,
    val nextDrawDate: String
)