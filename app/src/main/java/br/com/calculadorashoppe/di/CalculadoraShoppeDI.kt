package br.com.calculadorashoppe.di

import android.system.Os.bind
import br.com.calculadorashoppe.viewmodel.CalculatePriceSellContract
import br.com.calculadorashoppe.viewmodel.CalculatePriceSellViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object CalculadoraShoppeDI {

    val instance = module {
        single<CalculatePriceSellContract> { CalculatePriceSellViewModel() }
    }
}