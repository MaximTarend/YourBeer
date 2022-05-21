package by.hometrainng.mvvmkoinhw6.viewModels

import androidx.lifecycle.ViewModel
import by.hometrainng.mvvmkoinhw6.repository.BeerRepository
import by.hometrainng.mvvmkoinhw6.room.BeerDao

class ListViewModel(
    private val beerDao: BeerDao,
    private val beerRepository: BeerRepository
) : ViewModel() {



}