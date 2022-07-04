package by.hometrainng.yourbeer.domain.usecase

import by.hometrainng.yourbeer.domain.model.Brewery
import by.hometrainng.yourbeer.domain.repository.BreweryRemoteRepository

class GetBreweryByIdUseCase(private val breweryRemoteRepository: BreweryRemoteRepository) {

    suspend operator fun invoke(id: String): Result<Brewery> {
        return breweryRemoteRepository.getBreweryById(id)
    }
}