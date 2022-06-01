package by.hometrainng.mvvmkoin6.domain.usecase

import by.hometrainng.mvvmkoin6.domain.model.Beer
import by.hometrainng.mvvmkoin6.domain.model.BeerDetails
import by.hometrainng.mvvmkoin6.domain.repository.BeerRepository

class GetBeerDetailsUseCase(private val beerRepository: BeerRepository) {

    suspend operator fun invoke(id: Int): Result<BeerDetails> {
        return beerRepository.getBeerDetails(id)
    }
}