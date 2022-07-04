package by.hometrainng.yourbeer.data.mapper

import by.hometrainng.yourbeer.data.model.BreweryDTO
import by.hometrainng.yourbeer.domain.model.Brewery

internal fun BreweryDTO.toDomainModel(): Brewery {
    return Brewery(
        id = id,
        name = name,
        longitude = longitude,
        latitude = latitude,
        websiteUrl = websiteUrl,
        phone = phone
    )
}

internal fun List<BreweryDTO>.toDomainModels(): List<Brewery> {
    return map { it.toDomainModel() }
}