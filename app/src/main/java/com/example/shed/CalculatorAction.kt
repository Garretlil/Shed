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

open class EnumOperation(val symbol:String,var priority:Int){
    open fun Calc(num1:Double, num2:Double):Double
    { return 0.0
    }// создаем объекты с одной переменной symbol, каждый объект означает операцию
    object Plus:EnumOperation("+",0){
        override fun Calc(num1:Double,num2:Double):Double{
            return num1+num2
        }
    }
    object Minus:EnumOperation("-",0){
        override fun Calc(num1:Double,num2:Double):Double{
            return num1-num2
        }
    }
    object Multiply:EnumOperation("*",1){
          override fun Calc(num1:Double,num2:Double):Double{
               return num1*num2
           }
    }
    object Divide:EnumOperation("/",1){
        override fun Calc(num1:Double,num2:Double):Double{
            return num1/num2
        }
    }
}
