package by.hometrainng.yourbeer.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import by.hometrainng.yourbeer.data.model.BeerEntity

@Database(entities = [BeerEntity::class], version = 1)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun beerDao(): BeerDao
}