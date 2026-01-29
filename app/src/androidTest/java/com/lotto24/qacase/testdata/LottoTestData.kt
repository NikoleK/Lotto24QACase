package com.lotto24.qacase.testdata

import com.lotto24.qacase.domain.model.LottoDomain

object LottoTestData {

    private val DEFAULT_6AUS49_NUMBERS = listOf(10, 32, 3, 40, 15, 6)
    private val DEFAULT_6AUS49_SUPER = listOf(7)

    fun sixAus49(
        lastDrawDate: String = "2026-01-24T18:00:00+01:00",
        numbers: List<Int> = DEFAULT_6AUS49_NUMBERS,
        superNumber: List<Int> = DEFAULT_6AUS49_SUPER,
        nextDrawDate: String = "2026-01-25T18:00:00+01:00"
    ) = LottoDomain(
        lottery = "6aus49",
        lastDrawDate = lastDrawDate,
        numbers = numbers,
        superNumber = superNumber,
        isEuroJackpot = false,
        nextDrawDate = nextDrawDate
    )

    fun euroJackpot(
        numbers: List<Int> = listOf(1, 2, 3, 4, 5),
        superNumber: List<Int> = listOf(6, 7)
    ) = LottoDomain(
        lottery = "EuroJackpot",
        lastDrawDate = "2024-01-15T18:00:00+01:00",
        numbers = numbers,
        superNumber = superNumber,
        isEuroJackpot = true,
        nextDrawDate = "2024-01-20T18:00:00+01:00"
    )
}