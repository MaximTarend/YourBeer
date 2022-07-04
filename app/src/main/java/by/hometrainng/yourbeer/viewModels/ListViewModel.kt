package by.hometrainng.yourbeer.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometrainng.yourbeer.domain.usecase.GetBeersFromDBUseCase
import by.hometrainng.yourbeer.domain.usecase.GetBeersUseCase
import by.hometrainng.yourbeer.domain.usecase.InsertBeersToDBUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class ListViewModel(
    private val getBeersUseCase: GetBeersUseCase,
    private val getBeersFromDBUseCase: GetBeersFromDBUseCase,
    private val insertBeersToDBUseCase: InsertBeersToDBUseCase
) : ViewModel() {

    private var isLoading = false
    private var currentPage = 1

    private val loadMoreFlow = MutableSharedFlow<Unit>(
        replay = 1, extraBufferCapacity = 0, onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val dataFlow = loadMoreFlow
        .filter { !isLoading }
        .onEach { isLoading = true }
        .map {
            getBeersUseCase(currentPage, PAGE_SIZE)
                .fold(
                    onSuccess = { it },
                    onFailure = { emptyList() }
                )
        }
        .onEach {
            insertBeersToDBUseCase(it)
            isLoading = false
            currentPage++
        }
        .runningReduce { accumulator, value -> accumulator + value }
        .onStart { emit(getBeersFromDBUseCase()) }
        .shareIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            replay = 1
        )

    init {
        onLoadMore()
    }

    fun onLoadMore() {
        loadMoreFlow.tryEmit(Unit)
    }

    companion object {
        private const val PAGE_SIZE = 25
    }
}