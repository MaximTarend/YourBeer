package by.hometrainng.yourbeer.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometrainng.yourbeer.domain.usecase.GetBreweryByIdUseCase
import by.hometrainng.yourbeer.model.LceState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class BottomSheetInfoViewModel(
    private val breweryID: String,
    private val getBreweryByIdUseCase: GetBreweryByIdUseCase
): ViewModel() {

    val loadInfoFlow = flow {
        val state = getBreweryByIdUseCase(breweryID)
            .fold(
                onSuccess = { LceState.Content(it) },
                onFailure = { LceState.Error(it) }
            )
        emit(state)
    }.shareIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        replay = 1
    )
}