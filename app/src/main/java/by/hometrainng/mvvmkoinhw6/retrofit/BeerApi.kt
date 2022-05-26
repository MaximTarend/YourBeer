package by.hometrainng.mvvmkoinhw6.retrofit

import by.hometrainng.mvvmkoinhw6.model.Beer
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BeerApi {


    @GET("beers")
    suspend fun getAllBeers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<Beer>

    @GET("beers/{id}")
    suspend fun gerBeerById(
        @Path("id") id : Int
    ) : Beer

    @GET("beers/random")
    suspend fun getRandomBeer() : Beer
}