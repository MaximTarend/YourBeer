package by.hometrainng.mvvmkoinhw6.viewModels

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometrainng.mvvmkoin6.data.map.LocationService
import by.hometrainng.mvvmkoin6.domain.model.Brewery
import by.hometrainng.mvvmkoin6.domain.usecase.GetBreweriesByDistUseCase
import by.hometrainng.mvvmkoin6.domain.usecase.GetBreweriesUseCase
import by.hometrainng.mvvmkoin6.domain.usecase.GetBreweryByIdUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class BreweryMapViewModel(
    private val locationService: LocationService,
    private val getBreweriesByDistUseCase: GetBreweriesByDistUseCase
) : ViewModel() {

    private var isLoading = false
    private var currentPage = 2



    private val dataFlow = MutableSharedFlow<Unit>(
        replay = 1, extraBufferCapacity = 0, onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    @SuppressLint("MissingPermission")
    val loadBreweriesByDistFlow = dataFlow
        .filter { !isLoading }
        .onEach { isLoading = true }
        .map {
            val location = locationService.getCurrentLocation()
            "${location.latitude},${location.longitude}"
        }
        .map {
            getBreweriesByDistUseCase(it, currentPage, PAGE_SIZE)
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