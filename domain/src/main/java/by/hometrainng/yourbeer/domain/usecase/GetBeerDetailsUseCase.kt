package by.hometrainng.yourbeer.domain.usecase

import by.hometrainng.yourbeer.domain.model.BeerDetails
import by.hometrainng.yourbeer.domain.repository.BeerRemoteRepository

class GetBeerDetailsUseCase(private val beerRemoteRepository: BeerRemoteRepository) {

    suspend operator fun invoke(id: Int): Result<BeerDetails> {
        return beerRemoteRepository.getBeerDetails(id)
    }
}