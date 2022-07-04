package by.hometrainng.yourbeer.koin

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import by.hometrainng.yourbeer.data.map.LocationService

val locationModule = module {
    singleOf(::LocationService)
}
