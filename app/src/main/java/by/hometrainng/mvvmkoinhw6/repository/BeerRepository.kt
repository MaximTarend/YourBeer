package by.hometrainng.mvvmkoinhw6.repository

import by.hometrainng.mvvmkoinhw6.retrofit.BeerApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BeerRepository(private val beerApi: BeerApi) {

/*    suspend fun getAllBeers() = withContext(Dispatchers.IO) {
        beerApi.getAllBeers()
    }*/

    suspend fun getAllBeers(page: Int, perPage: Int) = withContext(Dispatchers.IO) {
        beerApi.getAllBeers(page, perPage)
    }

    suspend fun getBeerDetails(id: Int) = withContext(Dispatchers.IO) {
        beerApi.gerBeerById(id)
    }

    suspend fun getRandomBeer() = withContext(Dispatchers.IO) {
        beerApi.getRandomBeer()
    }
}