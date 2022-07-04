package by.hometrainng.yourbeer.domain.usecase

import by.hometrainng.yourbeer.domain.model.Beer
import by.hometrainng.yourbeer.domain.repository.BeerLocalRepository

class InsertBeersToDBUseCase(private val beerLocalRepository: BeerLocalRepository) {

    suspend operator fun invoke(beers: List<Beer>) {
        beerLocalRepository.insertBeersToDB(beers)
    }
}