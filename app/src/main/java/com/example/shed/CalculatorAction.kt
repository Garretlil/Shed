package com.example.shed
 open class CalculatorAction(){
    data class Number(val number:Int):CalculatorAction()
    data class Operation(val operation:CalculatorOperation):CalculatorAction()
    //var Clear:CalculatorAction =CalculatorAction()
    object Clear:CalculatorAction()
    object Delete:CalculatorAction()
    object Decimal:CalculatorAction()
    object Calculate:CalculatorAction()
}
sealed class CalculatorOperation(val symbol:String){ // создаем объекты с одной переменной symbol, каждый объект означает операцию
    object Plus:CalculatorOperation("+")
    object Minus:CalculatorOperation("-")
    object Multiply:CalculatorOperation("*")
    object Divide:CalculatorOperation("/")
}