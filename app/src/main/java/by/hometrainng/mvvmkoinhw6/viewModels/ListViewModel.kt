package by.hometrainng.mvvmkoinhw6.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometrainng.mvvmkoinhw6.repository.BeerRepository
import by.hometrainng.mvvmkoinhw6.room.AppDatabase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class ListViewModel(
    private val appDatabase: AppDatabase,
    private val beerRepository: BeerRepository
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
        .filter { !isLoading }
        .onEach { isLoading = true }
        .map { beerRepository.getAllBeers(currentPage, PAGE_SIZE) }
        .onEach {
            println()
            appDatabase.beerDao().insertBeers(it)
            isLoading = false
            currentPage++
        }
        .runningReduce { accumulator, value -> accumulator + value }
        .onStart { emit(appDatabase.beerDao().getBeers()) }
//        .shareIn(
//            viewModelScope, SharingStarted.Eagerly, 1
//        )

    fun onLoadMore() {
        loadMoreFlow.tryEmit(Unit)
    }

    companion object {
        private const val PAGE_SIZE = 25
    }
}