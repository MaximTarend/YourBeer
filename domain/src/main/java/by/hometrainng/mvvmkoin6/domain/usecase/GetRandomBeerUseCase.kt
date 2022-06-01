package by.hometrainng.mvvmkoin6.domain.usecase

import by.hometrainng.mvvmkoin6.domain.model.BeerDetails
import by.hometrainng.mvvmkoin6.domain.repository.BeerRepository

class GetRandomBeerUseCase(private val beerRepository: BeerRepository) {

    suspend operator fun invoke(): Result<BeerDetails> {
        return beerRepository.getRandomBeer()
    }
}