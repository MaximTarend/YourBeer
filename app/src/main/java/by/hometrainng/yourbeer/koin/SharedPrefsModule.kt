package by.hometrainng.yourbeer.data.koin

import by.hometrainng.yourbeer.manager.SharedPrefsManager
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val sharedPrefsModule = module {
    singleOf(::SharedPrefsManager)
}