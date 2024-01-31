package br.com.calculadorashoppe.states

import android.provider.ContactsContract.RawContacts.Data
import br.com.calculadorashoppe.model.DataCalculateProfit

sealed class DataState {
    object Inactive: DataState()
    data class ResponseData(val data: Float): DataState()
    data class Error(val error: String?): DataState()
}