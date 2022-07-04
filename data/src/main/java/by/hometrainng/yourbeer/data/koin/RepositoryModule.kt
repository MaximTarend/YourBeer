package by.hometrainng.yourbeer.data.koin

import by.hometrainng.yourbeer.data.repository.BeerLocalRepositoryImpl
import by.hometrainng.yourbeer.data.repository.BeerRemoteRepositoryImpl
import by.hometrainng.yourbeer.data.repository.BreweryRemoteRepositoryImpl
import by.hometrainng.yourbeer.domain.repository.BeerLocalRepository
import by.hometrainng.yourbeer.domain.repository.BeerRemoteRepository
import by.hometrainng.yourbeer.domain.repository.BreweryRemoteRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf

import org.koin.dsl.module

internal val repositoryModule = module {

    singleOf(::BeerRemoteRepositoryImpl) {
        bind<BeerRemoteRepository>()
/*        named("beer")*/
    }

//    single { BeerLocalRepositoryImpl(get()) }.bind<BeerLocalRepository>()
    singleOf(::BeerLocalRepositoryImpl) {  bind<BeerLocalRepository>() }

    singleOf(::BreweryRemoteRepositoryImpl) {
        bind<BreweryRemoteRepository>()
/*        named("brewery")*/
    }
}
