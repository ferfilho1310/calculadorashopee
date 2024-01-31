package br.com.calculadorashoppe.viewmodel

import br.com.calculadorashoppe.model.DataCalculateProfit

interface CalculatePriceSellContract {

    fun calculatePriceSell(dataCalculateProfit: DataCalculateProfit)

    fun handleIntent(dataCalculateProfit: DataCalculateProfit)

}