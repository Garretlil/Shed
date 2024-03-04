package com.example.shed

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
    var showtext:MutableState<String> = mutableStateOf("")
    var listcalc :ListCalc=ListCalc(showtext)

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.ActionSymbol  -> listcalc.addtoList(action)
            is CalculatorAction.ActionOperation  -> listcalc.addtoList(action)
            else -> {return}
        }
    }
    fun onAction2(action:EnumCalculation){
        when (action){
            is EnumCalculation.Calculate -> listcalc.Calculate()
            is EnumCalculation.Delete    -> listcalc.Delete()
            is EnumCalculation.Clear     -> listcalc.Clear()
            is EnumCalculation.Decimal   -> listcalc.Decimal()
        }
    }

}
