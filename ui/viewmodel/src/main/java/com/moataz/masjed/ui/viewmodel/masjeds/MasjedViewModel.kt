package com.moataz.masjed.ui.viewmodel.masjeds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moataz.masjed.domain.usecases.GetAllMasjedsUsecase
import com.moataz.masjed.domain.usecases.utils.MasjedResult
import com.moataz.masjed.ui.viewmodel.models.MasjedsUIState
import com.moataz.masjed.ui.viewmodel.models.mapper.toMasjeds
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MasjedViewModel @Inject constructor(
    private val getAllMasjedsUsecase: GetAllMasjedsUsecase,
) : ViewModel() {

    private val _masjedsUiState = MutableStateFlow(MasjedsUIState())
    val masjedsUiState get() = _masjedsUiState.asStateFlow()

    init {
        getAllMasjeds()
    }

    private fun getAllMasjeds() {
        viewModelScope.launch {
            getAllMasjedsUsecase().collect { masjedResult ->
                when (masjedResult) {
                    is MasjedResult.Loading -> {
                        _masjedsUiState.update { it.copy(isLoading = true) }
                    }

                    is MasjedResult.Success -> {
                        _masjedsUiState.update {
                            it.copy(
                                masjeds = masjedResult.masjeds.toMasjeds(),
                                isLoading = false,
                                isError = false,
                                isSuccessful = true
                            )
                        }
                    }

                    is MasjedResult.EmptyResult -> {
                        _masjedsUiState.update {
                            it.copy(
                                isLoading = false,
                                isError = false,
                                isSuccessful = true,
                                masjeds = emptyList()
                            )
                        }
                    }

                    is MasjedResult.NoInternet -> {
                        _masjedsUiState.update {
                            it.copy(
                                masjeds = masjedResult.cachedMasjeds.toMasjeds(),
                                isLoading = false,
                                isError = false,
                                isSuccessful = true
                            )
                        }
                    }

                    is MasjedResult.Failure -> {
                        _masjedsUiState.update {
                            it.copy(
                                isError = true,
                                isLoading = false,
                                isSuccessful = false,
                                masjeds = emptyList()
                            )
                        }
                    }
                }
            }
        }
    }

    fun retryLoadMasjeds() {
        getAllMasjeds()
    }
}
