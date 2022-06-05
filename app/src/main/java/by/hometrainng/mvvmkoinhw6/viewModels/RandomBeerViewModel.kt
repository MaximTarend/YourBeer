package by.hometrainng.mvvmkoinhw6.viewModels

import androidx.lifecycle.ViewModel
import by.hometrainng.mvvmkoin6.domain.usecase.GetRandomBeerUseCase
import by.hometrainng.mvvmkoinhw6.model.LceState
import kotlinx.coroutines.flow.*

class RandomBeerViewModel(
    private val getRandomBeerUseCase: GetRandomBeerUseCase
) : ViewModel() {

    val loadRandomFlow = flow {
        val state = getRandomBeerUseCase()
            .fold(
                onSuccess = { LceState.Content(it) },
                onFailure = { LceState.Error(it) }
            )
        emit(state)
    }
}