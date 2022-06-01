package by.hometrainng.mvvmkoin6.domain.usecase

import by.hometrainng.mvvmkoin6.domain.model.Beer
import by.hometrainng.mvvmkoin6.domain.repository.BeerRepository

class GetBeersUseCase(private val beerRepository: BeerRepository) {

    suspend operator fun invoke(page: Int, perPage: Int): Result<List<Beer>> {
        return beerRepository.getAllBeers(page, perPage)
    }
}