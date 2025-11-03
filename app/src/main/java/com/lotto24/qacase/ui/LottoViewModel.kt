package com.lotto24.qacase.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lotto24.qacase.domain.model.LottoDomain
import com.lotto24.qacase.domain.usecase.GetLottoResultsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LottoViewModel @Inject constructor(
    private val getLottoResultsUseCase: GetLottoResultsUseCase
) : ViewModel() {

    private val _lottoResults = MutableStateFlow<List<LottoDomain>>(emptyList())
    val lottoResults = _lottoResults.asStateFlow()

    init {
        loadLottoResults()
    }

    private fun loadLottoResults() {
        viewModelScope.launch {
            val results = getLottoResultsUseCase()
            _lottoResults.value = results
        }
    }
}