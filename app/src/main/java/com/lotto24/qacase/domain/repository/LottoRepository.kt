package com.lotto24.qacase.domain.repository

import com.lotto24.qacase.domain.model.LottoDomain

interface LottoRepository {
    suspend fun getLottoResults(): List<LottoDomain>
}