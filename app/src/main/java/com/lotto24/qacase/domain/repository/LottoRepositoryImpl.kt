package com.lotto24.qacase.domain.repository

import com.lotto24.qacase.data.remote.LottoApi
import com.lotto24.qacase.domain.model.LottoDomain

class LottoRepositoryImpl(private val api: LottoApi) : LottoRepository {
    override suspend fun getLottoResults(): List<LottoDomain> {
        return api.getLottoResult().mapNotNull { lottoDto ->
            val lastDraw = lottoDto.lastDraw ?: return@mapNotNull null
            val nextDraw = lottoDto.nextDraw ?: return@mapNotNull null
            val drawResult = lastDraw.drawResult

            val isEuro = lottoDto.lottery.contains("EuroJackpot", ignoreCase = true)

            val specialNumbers = mutableListOf<Int>()
            drawResult.superNumber?.let { specialNumbers.add(it) }
            drawResult.euroNumbers?.let { specialNumbers.addAll(it) }

            LottoDomain(
                lottery = lottoDto.lottery,
                lastDrawDate = lastDraw.drawDate,
                nextDrawDate = nextDraw.drawDate,
                numbers = drawResult.numbers ?: emptyList(),
                superNumber = specialNumbers,
                isEuroJackpot = isEuro
            )
        }
    }
}