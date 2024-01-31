package br.com.calculadorashoppe.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.calculadorashoppe.intent.DataIntent
import br.com.calculadorashoppe.model.DataCalculateProfit
import br.com.calculadorashoppe.states.DataState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class CalculatePriceSellViewModel : ViewModel(), CalculatePriceSellContract {

    val dataIntent = Channel<DataIntent>(Channel.UNLIMITED)
    val dataState: MutableStateFlow<DataState> = MutableStateFlow(DataState.Inactive)


    override fun calculatePriceSell(dataCalculateProfit: DataCalculateProfit) {
        viewModelScope.launch {
            dataCalculateProfit.apply {
                dataState.value = DataState.ResponseData(price.toFloat() + fee.toFloat() + add.toFloat() + profit)
            }
        }
    }

    override fun handleIntent(dataCalculateProfit: DataCalculateProfit) {
        viewModelScope.launch {
            dataIntent.consumeAsFlow().collect {
                when(it) {
                    DataIntent.CalculateProfit -> calculatePriceSell(dataCalculateProfit)
                }
            }
        }
    }
}