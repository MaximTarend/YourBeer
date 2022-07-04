package by.hometrainng.yourbeer.data.koin

import by.hometrainng.yourbeer.data.api.BeerApi
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
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        get<Retrofit>(named("beer")).create<BeerApi>()
    }
}

