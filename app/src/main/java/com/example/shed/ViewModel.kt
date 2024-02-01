package com.example.shed

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(CalculatorState())
    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> setNumber(action.number)
            is CalculatorAction.Calculate -> Calculate()
            is CalculatorAction.Clear -> Clear()
            is CalculatorAction.Delete ->Delete()
            is CalculatorAction.Operation ->setOperation(action.operation)
            is CalculatorAction.Decimal-> Decimal()
        }
    }
    private fun setNumber(number:Int){
        if (state.operation==null)
        {
            state=state.copy(number1=state.number1+number.toString())
        }
        else
        {
            state=state.copy(number1=state.number2+number.toString())
        }

    }
    private fun Calculate(){

        val number1=state.number1.toDoubleOrNull()
        val number2=state.number1.toDoubleOrNull()
        if (number1!=null && number2!=null) {
            val result = when (state.operation) {
                is CalculatorOperation.Plus -> number1 + number2
                is CalculatorOperation.Minus -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                null -> return
            }
            state = state.copy(number1 = result.toString(),
                               number2="",
                operation = null)

        }
    }
    private fun Clear(){
        state=state.copy(number1="",operation=null,number2="")
    }
    private fun Delete(){
        if(state.number2!=""){
            state=state.copy(number2=state.number2.dropLast(1))
        }
        else{
            if (state.operation!=null){state=state.copy(operation=null)}
            else{
                if(state.number1!="") {
                    state=state.copy(number2=state.number1.dropLast(1))
                }
              }
        }
    }
    private fun setOperation(operation:CalculatorOperation){
        if (state.operation!=null){return}
        else { state=state.copy(operation=operation)}
    }
    private fun Decimal(){
        if(state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        } else if(!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }
}
