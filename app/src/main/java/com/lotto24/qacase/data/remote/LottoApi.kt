package com.lotto24.qacase.data.remote

import com.lotto24.qacase.data.model.Lotto
import retrofit2.http.GET

interface LottoApi {
    @GET("aggregated/6aus49,eurojackpot")
    suspend fun getLottoResult(): List<Lotto.LottoDto>

}