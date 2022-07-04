package by.hometrainng.yourbeer.data.koin

import by.hometrainng.yourbeer.data.api.BreweryApi
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

internal val network2Module = module {

    single(named("brewery")) {
        Retrofit.Builder()
            .baseUrl("https://api.openbrewerydb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        get<Retrofit>(named("brewery")).create<BreweryApi>()
    }
}