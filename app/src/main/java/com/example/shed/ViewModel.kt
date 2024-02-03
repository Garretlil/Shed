package com.example.shed

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CalculatorViewModel: ViewModel() {
   // "+","-",
    var fuckopers: MutableList<String> = mutableListOf("*","/")
    var PlusMinus:MutableList<String> = mutableListOf("+","-")
    var state by mutableStateOf(CalculatorState())
    var listcalc:ListCalc=ListCalc()
    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.ActionSymbol -> listcalc.addtoList(action)

            is CalculatorAction.ActionCalc -> Calculate(action)

            //is CalculatorAction.Operation ->setOperation(action.operation)
            //is CalculatorAction.Decimal-> Decimal()
            else -> {return}
        }
    }

    private fun Calculate(action:CalculatorAction){
        if (state.numbers.size<=3){return}
        else{
            for (i in state.numbers.indices step 3){
                if (i==state.numbers.size-3){break}
            }
        }
    }
    private fun Clear(){
        state.numbers.clear()
    }
    private fun Delete(){
        var index:Int=0;
        if (state.numbers.size==0){index=0}
        else{index=state.numbers.size-1}
        if (!state.numbers.isEmpty()) {
            when {
                state.numbers[index] in PlusMinus -> state.numbers.removeLast()
                state.numbers[index] !in PlusMinus -> state.numbers[index]=state.numbers[index].dropLast(1)
            }
        }
    }

    //private fun Decimal(){
    //    if(state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
    //        state = state.copy(
    //            number1 = state.number1 + "."
    //        )
    //        return
    //    } else if(!state.number2.contains(".") && state.number2.isNotBlank()) {
    //        state = state.copy(
    //            number2 = state.number2 + "."
    //        )
   //     }

}
