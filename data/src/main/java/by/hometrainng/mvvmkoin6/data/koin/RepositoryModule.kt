package by.hometrainng.mvvmkoin6.data.koin

import by.hometrainng.mvvmkoin6.data.repository.BeerRemoteRepository
import by.hometrainng.mvvmkoin6.domain.repository.BeerRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val repositoryModule = module {

    singleOf(::BeerRemoteRepository) { bind<BeerRepository>() }
}
