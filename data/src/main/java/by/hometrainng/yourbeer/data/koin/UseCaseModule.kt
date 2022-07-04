package by.hometrainng.yourbeer.data.koin

import by.hometrainng.yourbeer.domain.usecase.GetBeerDetailsUseCase
import by.hometrainng.yourbeer.domain.usecase.GetBeersUseCase
import by.hometrainng.yourbeer.domain.usecase.GetRandomBeerUseCase
import by.hometrainng.yourbeer.domain.usecase.GetBeersFromDBUseCase
import by.hometrainng.yourbeer.domain.usecase.InsertBeersToDBUseCase
import by.hometrainng.yourbeer.domain.usecase.GetBreweriesByDistUseCase
import by.hometrainng.yourbeer.domain.usecase.GetBreweryByIdUseCase
import by.hometrainng.yourbeer.domain.usecase.GetBreweriesUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val useCaseModule = module {
    factoryOf(::GetBeersUseCase)
    factoryOf(::GetBeerDetailsUseCase)
    factoryOf(::GetRandomBeerUseCase)
    factoryOf(::GetBeersFromDBUseCase)
    factoryOf(::InsertBeersToDBUseCase)
    factoryOf(::GetBreweriesByDistUseCase)
    factoryOf(::GetBreweryByIdUseCase)
    factoryOf(::GetBreweriesUseCase)
}