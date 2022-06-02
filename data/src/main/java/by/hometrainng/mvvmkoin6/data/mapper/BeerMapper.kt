package by.hometrainng.mvvmkoin6.data.mapper

import by.hometrainng.mvvmkoin6.data.model.BeerDTO
import by.hometrainng.mvvmkoin6.data.model.BeerEntity
import by.hometrainng.mvvmkoin6.domain.model.Beer
import by.hometrainng.mvvmkoin6.domain.model.BeerDetails

fun List<BeerDTO>.toDomainModels(): List<Beer> {
    return map { it.toDomainModel() }
}

fun BeerDTO.toDomainModel(): Beer {
    return Beer(
        id = id,
        name = name,
        imageURL = imageURL
    )
}

fun BeerDTO.toDetailsDomainModel(): BeerDetails {
    return BeerDetails(
        id = id,
        name = name,
        description = description,
        imageURL = imageURL,
    )
}

fun List<BeerEntity>.toDomainModel(): List<Beer> { // TODO - проблема с дженериками
    return map { it.toDomainModel() }
}

fun BeerEntity.toDomainModel(): Beer {
    return Beer(
        id = id,
        name = name,
        imageURL = imageURL
    )
}