package by.hometrainng.mvvmkoinhw6.viewModels

import androidx.lifecycle.ViewModel
import by.hometrainng.mvvmkoinhw6.model.LceState
import by.hometrainng.mvvmkoinhw6.repository.BeerRepository
import kotlinx.coroutines.flow.*

class RandomBeerViewModel(
    private val beerRepository: BeerRepository
) : ViewModel() {

    val loadRandomFlow = flow {
        val state = beerRepository.getRandomBeer()
            .fold(
                onSuccess = { LceState.Content(it) },
                onFailure = { LceState.Error(it) }
            )
        emit(state)
    }
}