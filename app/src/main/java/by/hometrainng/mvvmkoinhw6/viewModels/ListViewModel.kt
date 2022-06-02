package by.hometrainng.mvvmkoinhw6.viewModels

import androidx.lifecycle.ViewModel
import by.hometrainng.mvvmkoin6.domain.repository.BeerRepository
import by.hometrainng.mvvmkoin6.domain.usecase.GetBeersUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class ListViewModel(
    private val getBeersUseCase: GetBeersUseCase
) : ViewModel() {

    private var isLoading = false
    private var currentPage = 1

    private val loadMoreFlow = MutableSharedFlow<Unit> (
        replay = 1, extraBufferCapacity = 0, onBufferOverflow = BufferOverflow.DROP_OLDEST
            )

    init {
        onLoadMore()
    }

    val dataFlow = loadMoreFlow
        .map {
            getBeersUseCase(currentPage, PAGE_SIZE).getOrDefault(emptyList())
        }

/*    val dataFlow = loadMoreFlow
        .filter { !isLoading }
        .onEach { isLoading = true }
        .map {
            runCatching { beerRepository.getAllBeers(currentPage, PAGE_SIZE) }
                .fold(
                    onSuccess = { it },
                    onFailure = { error("Upload Failure") }
                )
        }
        .onEach {
                    appDatabase.beerDao().insertBeers(it)
                    isLoading = false
                    currentPage++
        }
        .runningReduce { accumulator, value -> accumulator + value }
        .onStart { emit(appDatabase.beerDao().getBeers()) }
        .shareIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            replay = 1
        )*/

    fun onLoadMore() {
        loadMoreFlow.tryEmit(Unit)
    }

    companion object {
        private const val PAGE_SIZE = 25
    }
}