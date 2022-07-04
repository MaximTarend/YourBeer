package by.hometrainng.yourbeer.data.koin

import by.hometrainng.yourbeer.koin.locationModule
import org.koin.dsl.module

val dataModule = module {
    includes(
        databaseModule,
        repositoryModule,
        networkModule,
        network2Module,
        useCaseModule,
        locationModule
    )
}