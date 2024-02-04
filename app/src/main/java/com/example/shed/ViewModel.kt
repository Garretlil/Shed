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
//    private fun Clear(){
//        state.numbers.clear()
//    }


//    private fun Delete(){
//        var index:Int=0;
//        if (state.numbers.size==0){index=0}
//        else{index=state.numbers.size-1}
//        if (!state.numbers.isEmpty()) {
//            when {
//                state.numbers[index] in PlusMinus -> state.numbers.removeLast()
//                state.numbers[index] !in PlusMinus -> state.numbers[index]=state.numbers[index].dropLast(1)
//            }
//        }
//    }

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

    //                when ((this[i] as ItemOper).oper){
//                    is EnumOperation.Plus -> str+=
//                    is EnumOperation.Minus -> str+="-"
//                    is EnumOperation.Multiply -> str+="*"
//                    is EnumOperation.Divide -> str+="/"
//               }

}
