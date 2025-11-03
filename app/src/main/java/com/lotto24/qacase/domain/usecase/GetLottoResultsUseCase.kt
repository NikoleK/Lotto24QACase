package com.lotto24.qacase.domain.usecase

import com.lotto24.qacase.domain.repository.LottoRepository

class GetLottoResultsUseCase(private val repository: LottoRepository) {
    suspend operator fun invoke() = repository.getLottoResults()
}