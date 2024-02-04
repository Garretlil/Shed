package com.example.shed
 open class CalculatorAction(){
    data class ActionSymbol(val symbol: String):CalculatorAction()
    data class ActionOperation(val operation:EnumOperation):CalculatorAction()
     data class ActionCalc(val calcbutton:EnumCalculation):CalculatorAction()
    //var Clear:CalculatorAction =CalculatorAction()
}
open class EnumCalculation(){ // создаем объекты с одной переменной symbol, каждый объект означает операцию
    object Clear:EnumCalculation()
    object Delete:EnumCalculation()
    object Decimal:EnumCalculation()
    object Calculate:EnumCalculation()
}

open class EnumOperation(val symbol:String){ // создаем объекты с одной переменной symbol, каждый объект означает операцию
    object Plus:EnumOperation("+")
    object Minus:EnumOperation("-")
    object Multiply:EnumOperation("*")
    object Divide:EnumOperation("/")
}