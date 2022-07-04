package by.hometrainng.yourbeer.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import by.hometrainng.yourbeer.data.model.BeerEntity

@Dao
internal interface BeerDao {

    @Query("SELECT * FROM beerentity")
    suspend fun getBeers(): List<BeerEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertBeers(beers: List<BeerEntity>)
}