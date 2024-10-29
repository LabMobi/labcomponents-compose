package mobi.lab.components.compose.demo

import android.app.Application
import timber.log.Timber

open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
