package by.hometrainng.mvvmkoinhw6.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometrainng.mvvmkoin6.domain.model.Brewery
import by.hometrainng.mvvmkoin6.domain.usecase.GetBreweriesByDistUseCase
import by.hometrainng.mvvmkoin6.domain.usecase.GetBreweriesUseCase
import by.hometrainng.mvvmkoin6.domain.usecase.GetBreweryByIdUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class BreweryMapViewModel(
    private val location: String,
    private val getBreweriesByDistUseCase: GetBreweriesByDistUseCase
) : ViewModel() {

    private var isLoading = false
    private var currentPage = 2

    private val dataFlow = MutableSharedFlow<Unit>(
        replay = 1, extraBufferCapacity = 0, onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val loadBreweriesByDistFlow = dataFlow
        .filter { !isLoading }
        .onEach { isLoading = true }
        .map {
            getBreweriesByDistUseCase(location, currentPage, PAGE_SIZE)
                .fold(
                    onSuccess = { it },
                    onFailure = { emptyList() }
                )
        }
        .onEach {
            currentPage++
            isLoading = false
        }
        .runningReduce { accumulator, value -> accumulator + value }

    init {
        onLoadMore()
    }

    fun onLoadMore() {
        dataFlow.tryEmit(Unit)
    }

    companion object {
        private const val PAGE_SIZE = 50
    }
}