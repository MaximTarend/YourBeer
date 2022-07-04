package by.hometrainng.yourbeer.domain.usecase

import by.hometrainng.yourbeer.domain.model.Beer
import by.hometrainng.yourbeer.domain.repository.BeerRemoteRepository

class GetBeersUseCase(private val beerRemoteRepository: BeerRemoteRepository) {

    suspend operator fun invoke(page: Int, perPage: Int): Result<List<Beer>> {
        return beerRemoteRepository.getAllBeers(page, perPage)
    }
}