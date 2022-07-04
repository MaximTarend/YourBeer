package by.hometrainng.yourbeer.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometrainng.yourbeer.domain.usecase.GetRandomBeerUseCase
import by.hometrainng.yourbeer.model.LceState
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class RandomBeerViewModel(
    private val getRandomBeerUseCase: GetRandomBeerUseCase
) : ViewModel() {


    private val loadNewRandomFlow = MutableSharedFlow<Unit>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val loadRandomFlow = loadNewRandomFlow
        .mapLatest{
            getRandomBeerUseCase()
                .fold(
                    onSuccess = { LceState.Content(it) },
                    onFailure = { LceState.Error(it) }
                )
        }.shareIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            replay = 1
        )

/*    val loadRandomFlow = flow {
        val state = getRandomBeerUseCase()
            .fold(
                onSuccess = { LceState.Content(it) },
                onFailure = { LceState.Error(it) }
            )
        emit(state)
    }.shareIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        replay = 1
    )*/

    init {
        onClickedRandom()
    }

    fun onClickedRandom() {
        loadNewRandomFlow.tryEmit(Unit)
    }
}
