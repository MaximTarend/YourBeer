package by.hometrainng.yourbeer.domain.usecase

import by.hometrainng.yourbeer.domain.model.Brewery
import by.hometrainng.yourbeer.domain.repository.BreweryRemoteRepository

class GetBreweriesByDistUseCase(private val breweryRemoteRepository: BreweryRemoteRepository) {

    suspend operator fun invoke(location: String, page: Int, perPage: Int): Result<List<Brewery>> {
        return breweryRemoteRepository.getBreweriesByDist(location, page, perPage)
    }
}