package by.hometrainng.mvvmkoin6.data.repository

import by.hometrainng.mvvmkoin6.data.database.BeerDao
import by.hometrainng.mvvmkoin6.data.mapper.toDomainModel
import by.hometrainng.mvvmkoin6.domain.model.Beer
import by.hometrainng.mvvmkoin6.domain.model.BeerDetails
import by.hometrainng.mvvmkoin6.domain.repository.BeerRepository

internal class BeerLocalRepository(
    private val beerDao: BeerDao
): BeerRepository {
    override suspend fun getAllBeers(page: Int, perPage: Int): Result<List<Beer>> {
        return runCatching {
            beerDao.getBeers()
        }.map {
            it.map {
                it.toDomainModel()
            }
        }
    }

    override suspend fun getBeerDetails(id: Int): Result<BeerDetails> {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomBeer(): Result<BeerDetails> {
        TODO("Not yet implemented")
    }
}