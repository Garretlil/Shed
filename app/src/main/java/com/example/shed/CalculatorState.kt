package com.example.shed

import androidx.compose.runtime.MutableState

data class CalculatorState(
    var numbers: MutableList<IManageItem> = mutableListOf()

    //var str:String=""
    //val number1:String="",
    //val number2:String="",
    //var operation:CalculatorOperation?=null
)
class ListCalc(showtxt_: MutableState<String> ) :MutableList<IManageItem> by mutableListOf(){
    var onActionChange: (str:String) -> Unit = ::change
    var showtxt=showtxt_
    fun change(str:String){
        showtxt.value=this.GetStringList()
    }
    fun addtoList(action: CalculatorAction){
        when(action){
            is CalculatorAction.ActionSymbol -> AddSymbol(action)
            is CalculatorAction.ActionOperation -> AddOper(action)
        }
    }
    fun AddSymbol(action:CalculatorAction){
        if (this.isEmpty()){this.add(ItemNumber())}
        if (this[this.count()-1] is ItemNumber){
            this[this.count()-1].Add((action as CalculatorAction.ActionSymbol).symbol)
        }
        else{this.add(ItemNumber())
            this[this.count()-1].Add((action as CalculatorAction.ActionSymbol).symbol)

        }
        onActionChange("")
    }
    fun AddOper(action:CalculatorAction){
        var item_:ItemOper=ItemOper()
        item_.oper=(action as CalculatorAction.ActionOperation).operation
        if (!this.isEmpty()) {
            if (this[this.count() - 1] is ItemNumber) {
                this.add(item_)
            }
        }
        onActionChange("")
    }
    fun Delete(){
        if (this[this.count()-1] is ItemNumber){
            this[this.count()-1].Delete()
            if ((this[this.count()-1] as ItemNumber).num==""){
                this.removeLast()
            }
        }
        else {
            this.removeLast()
        }
        onActionChange("")
    }
    fun Decimal(){
        if (this[this.count()-1] is ItemNumber){
            this[this.count()-1].Add(".")
            onActionChange("")
        }
        else {return}

    }
    fun Clear(){
        this.clear()
        onActionChange("")
    }

    fun GetStringList():String {
        var str:String=""

        for (i in 0..<this.count()){
            if (i%2==1){//оператор
                str+=(this[i] as ItemOper).oper.symbol
            }
            else{
                str+=(this[i] as ItemNumber).num
            }
        }

        return str
    }
    fun Calculate(){
        var sum:Int=((this[0] as ItemNumber).num).toInt()
        var len:Int=0
        if (this[this.count()-1] is ItemNumber){
            len=this.count()-1
        }
        else{len=this.count()-2 }
        for (i in 1..<len step 2){
            when{
                (this[i] as ItemOper).oper==EnumOperation.Plus -> sum+=((this[i+1] as ItemNumber).num).toInt()
                (this[i] as ItemOper).oper==EnumOperation.Minus -> sum-=((this[i+1] as ItemNumber).num).toInt()
                (this[i] as ItemOper).oper==EnumOperation.Multiply -> sum*=((this[i+1] as ItemNumber).num).toInt()
                (this[i] as ItemOper).oper==EnumOperation.Divide -> sum/=((this[i+1] as ItemNumber).num).toInt()
            }
        }
        showtxt.value=sum.toString()
        this.clear()
        this.AddSymbol(CalculatorAction.ActionSymbol(sum.toString()))

    }

}




