package by.hometrainng.yourbeer.domain.usecase

import by.hometrainng.yourbeer.domain.model.Brewery
import by.hometrainng.yourbeer.domain.repository.BreweryRemoteRepository

class GetBreweriesUseCase(private val breweryRemoteRepository: BreweryRemoteRepository) {

    suspend operator fun invoke(page: Int, perPage: Int): Result<List<Brewery>> {
        return breweryRemoteRepository.getBreweries(page, perPage)
    }
}