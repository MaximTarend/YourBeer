package by.hometrainng.yourbeer.domain.repository

import by.hometrainng.yourbeer.domain.model.Beer

interface BeerLocalRepository {

    suspend fun getBeersFromBD() : List<Beer>

    suspend fun insertBeersToDB(beers: List<Beer>)
}