package com.lotto24.qacase.di
import com.lotto24.qacase.data.remote.LottoApi
import com.lotto24.qacase.domain.repository.LottoRepository
import com.lotto24.qacase.domain.repository.LottoRepositoryImpl
import com.lotto24.qacase.domain.usecase.GetLottoResultsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLottoApi(): LottoApi = Retrofit.Builder()
        .baseUrl("https://www.lotto24.de/public/v1/drawinfo/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(LottoApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(api: LottoApi): LottoRepository = LottoRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideUseCase(repository: LottoRepository): GetLottoResultsUseCase =
        GetLottoResultsUseCase(repository)
}