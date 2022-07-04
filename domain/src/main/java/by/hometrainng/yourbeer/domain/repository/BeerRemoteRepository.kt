package by.hometrainng.yourbeer.domain.repository

import by.hometrainng.yourbeer.domain.model.Beer
import by.hometrainng.yourbeer.domain.model.BeerDetails

interface BeerRemoteRepository {

    suspend fun getAllBeers(page: Int, perPage: Int): Result<List<Beer>>

    suspend fun getBeerDetails(id: Int): Result<BeerDetails>

    suspend fun getRandomBeer(): Result<BeerDetails>
}