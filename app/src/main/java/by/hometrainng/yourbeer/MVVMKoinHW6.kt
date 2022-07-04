package by.hometrainng.yourbeer

import android.app.Application
import by.hometrainng.yourbeer.data.koin.dataModule
import by.hometrainng.yourbeer.data.koin.sharedPrefsModule
import by.hometrainng.yourbeer.koin.locationModule
import by.hometrainng.yourbeer.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MVVMKoinHW6: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MVVMKoinHW6)
            modules(
                dataModule,
                viewModelModule,
                sharedPrefsModule,
                locationModule
            )
        }
    }
}
