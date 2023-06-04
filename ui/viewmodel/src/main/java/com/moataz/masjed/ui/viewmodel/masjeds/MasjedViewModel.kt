package com.moataz.masjed.ui.viewmodel.masjeds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moataz.masjed.domain.usecases.GetAllMasjedsUsecase
import com.moataz.masjed.domain.usecases.utils.MasjedResult
import com.moataz.masjed.ui.viewmodel.models.MasjedsUIState
import com.moataz.masjed.ui.viewmodel.models.mapper.toMasjeds
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
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
            getAllMasjedsUsecase().runCatching {
                collect { masjedResult ->
                    when (masjedResult) {
                        is MasjedResult.Loading -> _masjedsUiState.update {
                            it.copy(isLoading = true)
                        }

                        is MasjedResult.Success -> _masjedsUiState.update {
                            it.copy(isLoading = false, masjeds = masjedResult.masjeds.toMasjeds())
                        }

                        is MasjedResult.EmptyResult -> _masjedsUiState.update {
                            it.copy(isLoading = false, masjeds = emptyList())
                        }

                        is MasjedResult.NoInternet -> _masjedsUiState.update {
                            it.copy(
                                isLoading = false,
                                masjeds = masjedResult.cachedMasjeds.toMasjeds()
                            )
                        }

                        is MasjedResult.Failure -> _masjedsUiState.update {
                            it.copy(isLoading = false, masjeds = emptyList(), isError = true)
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
