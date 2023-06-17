package com.moataz.masjed.ui.viewmodel.masjed_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moataz.masjed.domain.usecases.GetMasjedDetailsByIdUsecase
import com.moataz.masjed.domain.usecases.utils.MasjedResult
import com.moataz.masjed.ui.viewmodel.models.MasjedDetailsUI
import com.moataz.masjed.ui.viewmodel.models.mapper.toMasjedDetailsUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MasjedDetailsViewModel(
    private val getMasjedDetailsByIdUsecase: GetMasjedDetailsByIdUsecase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _masjedDetailsUiState = MutableStateFlow(MasjedDetailsUIState())
    val masjedDetailsUiState get() = _masjedDetailsUiState.asStateFlow()

    private val args = MasjedDetailsArgs(savedStateHandle)

    init {
        getMasjedDetails()
    }

    private fun getMasjedDetails() {
        viewModelScope.launch {
            getMasjedDetailsByIdUsecase(args.masjedId).runCatching {
                collect { masjedDetailsResult ->
                    when (masjedDetailsResult) {
                        is MasjedResult.Loading -> _masjedDetailsUiState.update {
                            it.copy(isLoading = true)
                        }

                        is MasjedResult.Success -> _masjedDetailsUiState.update {
                            it.copy(
                                isLoading = false,
                                masjedDetails = masjedDetailsResult.data.toMasjedDetailsUI()
                            )
                        }

                        is MasjedResult.EmptyResult -> _masjedDetailsUiState.update {
                            it.copy(isLoading = false, masjedDetails = MasjedDetailsUI())
                        }

                        is MasjedResult.NoInternet -> _masjedDetailsUiState.update {
                            it.copy(
                                isLoading = false,
                                masjedDetails = masjedDetailsResult.cashedData.toMasjedDetailsUI()
                            )
                        }

                        is MasjedResult.Failure -> _masjedDetailsUiState.update {
                            it.copy(
                                isLoading = false,
                                masjedDetails = MasjedDetailsUI(),
                                isError = true
                            )
                        }
                    }
                }
            }
        }
    }

    fun retryLoadMasjedDetails() {
        getMasjedDetails()
    }
}