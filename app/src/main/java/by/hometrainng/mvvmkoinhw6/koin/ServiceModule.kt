package by.hometrainng.mvvmkoinhw6.koin

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import by.hometrainng.mvvmkoinhw6.map.LocationService

val serviceModule = module {
    singleOf(::LocationService)
}