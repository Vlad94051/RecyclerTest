package ru.tms.recyclertest

import android.app.Application
import org.koin.core.context.startKoin
import ru.tms.recyclertest.data.di.dataModule
import ru.tms.recyclertest.presentation.di.viewModelsModule

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            modules(
                dataModule,
                viewModelsModule
            )
        }
    }
}