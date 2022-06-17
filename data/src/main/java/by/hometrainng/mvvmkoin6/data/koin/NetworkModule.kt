package by.hometrainng.mvvmkoin6.data.koin

import by.hometrainng.mvvmkoin6.data.api.BeerApi
import by.hometrainng.mvvmkoin6.data.api.BreweryApi
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

internal val networkModule = module {

    single {
        OkHttpClient.Builder().build()
    }

    single(named("beer")) {
        Retrofit.Builder()
            .baseUrl(" https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single(named("beer")) {
        get<Retrofit>().create<BeerApi>()
    }

    single(named("brewery")) {
        Retrofit.Builder()
            .baseUrl("https://api.openbrewerydb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single(named("brewery")) {
        get<Retrofit>().create<BreweryApi>()
    }
}

