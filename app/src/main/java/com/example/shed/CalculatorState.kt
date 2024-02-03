package com.example.shed

data class CalculatorState(
    var numbers: MutableList<IManageItem> = mutableListOf()

    //var str:String=""
    //val number1:String="",
    //val number2:String="",
    //var operation:CalculatorOperation?=null
)
class ListCalc() :MutableList<IManageItem> by mutableListOf(){
    fun addtoList(action: CalculatorAction){
        when(action){
            is CalculatorAction.ActionSymbol -> AddSymbol(action)
            is CalculatorAction.ActionOperation -> AddOper(action)
        }
    }
    fun AddSymbol(action:CalculatorAction){
        if (this[this.count()] is ItemNumber){
            this[this.count()].Add((action as CalculatorAction.ActionSymbol).symbol)
        }
    }
    fun AddOper(action:CalculatorAction){
        var item_:ItemOper=ItemOper()
        item_.oper=(action as CalculatorAction.ActionOperation).operation
        if (this[this.count()] is ItemNumber){
            this.add(item_)
        }
    }
}

