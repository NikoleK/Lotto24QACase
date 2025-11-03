package com.lotto24.qacase.data.model

class Lotto {
    data class LottoDto(
        val lottery: String,
        val lastDraw: LastDraw?,
        val nextDraw: NextDraw?
    )

    data class LastDraw(
        val drawIdentifier: String,
        val drawDate: String,
        val drawResult: DrawResult
    )

    data class DrawResult(
        val numbers: List<Int>?,
        val superNumber: Int?,
        val euroNumbers: List<Int>?
    )

    data class NextDraw(
        val drawIdentifier: String,
        val drawDate: String
    )
}