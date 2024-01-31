package br.com.calculadorashoppe.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class StartApplicationKoin: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@StartApplicationKoin)
            modules(CalculadoraShoppeDI.instance)
        }
    }
}