package by.hometrainng.yourbeer.domain.usecase

import by.hometrainng.yourbeer.domain.model.BeerDetails
import by.hometrainng.yourbeer.domain.repository.BeerRemoteRepository

class GetRandomBeerUseCase(private val beerRemoteRepository: BeerRemoteRepository) {

    suspend operator fun invoke(): Result<BeerDetails> {
        return beerRemoteRepository.getRandomBeer()
    }
}