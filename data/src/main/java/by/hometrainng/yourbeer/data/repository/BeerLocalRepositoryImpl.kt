package by.hometrainng.yourbeer.data.repository

import by.hometrainng.yourbeer.data.database.BeerDao
import by.hometrainng.yourbeer.data.mapper.toBeerEntity
import by.hometrainng.yourbeer.data.mapper.toDomainModel
import by.hometrainng.yourbeer.domain.model.Beer
import by.hometrainng.yourbeer.domain.repository.BeerLocalRepository

internal class BeerLocalRepositoryImpl(
    private val beerDao: BeerDao
): BeerLocalRepository {
    override suspend fun getBeersFromBD(): List<Beer> {
        return beerDao.getBeers().map {
                it.toDomainModel()
            }
    }

    override suspend fun insertBeersToDB(beers: List<Beer>) {
        beerDao.insertBeers(
            beers.map {
                it.toBeerEntity()
            }
        )
    }


}