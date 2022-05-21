package by.hometrainng.mvvmkoinhw6.viewModels

import androidx.lifecycle.ViewModel
import by.hometrainng.mvvmkoinhw6.repository.BeerRepository

class RandomBeerViewModel(
    private val beerRepository: BeerRepository
): ViewModel() {

}