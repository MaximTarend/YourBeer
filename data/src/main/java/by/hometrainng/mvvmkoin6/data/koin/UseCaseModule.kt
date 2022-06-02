package by.hometrainng.mvvmkoin6.data.koin

import by.hometrainng.mvvmkoin6.domain.usecase.GetBeerDetailsUseCase
import by.hometrainng.mvvmkoin6.domain.usecase.GetBeersUseCase
import by.hometrainng.mvvmkoin6.domain.usecase.GetRandomBeerUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::GetBeersUseCase)
    factoryOf(::GetBeerDetailsUseCase)
    factoryOf(::GetRandomBeerUseCase)
}