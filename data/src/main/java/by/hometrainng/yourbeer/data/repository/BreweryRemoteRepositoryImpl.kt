package by.hometrainng.yourbeer.data.repository

import by.hometrainng.yourbeer.data.api.BreweryApi
import by.hometrainng.yourbeer.data.mapper.toDomainModel
import by.hometrainng.yourbeer.data.mapper.toDomainModels
import by.hometrainng.yourbeer.domain.model.Brewery
import by.hometrainng.yourbeer.domain.repository.BreweryRemoteRepository

internal class BreweryRemoteRepositoryImpl(private val breweryApi: BreweryApi) : BreweryRemoteRepository {
    override suspend fun getBreweries(page: Int, perPage: Int): Result<List<Brewery>> {
        return runCatching {
            breweryApi.getBreweries(page, perPage)
        }.map { it.toDomainModels() }
    }

    override suspend fun getBreweryById(id: String): Result<Brewery> {
        return runCatching {
            breweryApi.getBreweryById(id)
        }.map { it.toDomainModel() }
    }

    override suspend fun getBreweriesByDist(
        location: String,
        page: Int,
        perPage: Int
    ): Result<List<Brewery>> {
        return runCatching {
            breweryApi.getBreweriesByDist(location, page, perPage)
        }.map { it.toDomainModels() }
    }
}