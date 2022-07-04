package by.hometrainng.yourbeer.domain.usecase

import by.hometrainng.yourbeer.domain.model.Beer
import by.hometrainng.yourbeer.domain.repository.BeerLocalRepository

class GetBeersFromDBUseCase(private val beerLocalRepository: BeerLocalRepository) {

    suspend operator fun invoke(): List<Beer> {
        return beerLocalRepository.getBeersFromBD()
    }
}