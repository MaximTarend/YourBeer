package by.hometrainng.yourbeer.data.koin

import androidx.room.Room
import by.hometrainng.yourbeer.data.database.AppDatabase
import org.koin.dsl.module

internal val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_database.db"
        ).build()
    }

    single { get<AppDatabase>().beerDao() }
}