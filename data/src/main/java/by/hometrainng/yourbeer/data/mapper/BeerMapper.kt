package by.hometrainng.yourbeer.data.mapper

import by.hometrainng.yourbeer.data.model.BeerDTO
import by.hometrainng.yourbeer.data.model.BeerEntity
import by.hometrainng.yourbeer.domain.model.Beer
import by.hometrainng.yourbeer.domain.model.BeerDetails

internal fun List<BeerDTO>.toDomainModels(): List<Beer> {
    return map { it.toDomainModel() }
}

internal fun BeerDTO.toDomainModel(): Beer {
    return Beer(
        id = id,
        name = name,
        imageURL = imageURL
    )
}

internal fun BeerDTO.toDetailsDomainModel(): BeerDetails {
    return BeerDetails(
        id = id,
        name = name,
        description = description,
        imageURL = imageURL,
        tagline = tagline,
        foodPairing = foodPairing,
        brewersTips = brewersTips
    )
}

internal fun List<BeerEntity>.toDomainModel(): List<Beer> { // TODO - проблема с дженериками
    return map { it.toDomainModel() }
}

internal fun BeerEntity.toDomainModel(): Beer {
    return Beer(
        id = id,
        name = name,
        imageURL = imageURL
    )
}

internal fun Beer.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        imageURL = imageURL
    )
}