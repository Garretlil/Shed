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
        if (!this.isEmpty()){
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
    fun HighPrioraCalc():MutableList<IManageItem>{
        //1+2*3-4/2+5+ :3 7
        //1+6-2+5
        //6 2
        var len:Int=0//длина
        val indexOpers:MutableList<Int> =mutableListOf()//индексы приоритетных выражений
        val listCalcNew :MutableList<IManageItem> = mutableListOf()//конечный список для подсчета
        var listCalcExpressions:MutableList<IManageItem> = mutableListOf()//подсчитанные выражения
        var miniList:MutableList<IManageItem> = mutableListOf()
        len = if (this[this.count()-1] is ItemNumber){
            this.count()-1
        } else{
            this.count()-2
        }
        if (this.isEmpty()){return this}
        for(i in 0..<this.count()-1){
            if ((this[i] is ItemOper)){
                if ((this[i] as ItemOper).oper.symbol=="*" || (this[i] as ItemOper).oper.symbol=="/") {
                    indexOpers.add(i)
                    miniList.clear()
                    miniList.add(this[i - 1]);miniList.add(this[i]);miniList.add(this[i + 1])
                    val thunder: Double = miniCalculate(miniList)
                    val item_: ItemNumber = ItemNumber()
                    item_.num = thunder.toString()
                    listCalcExpressions.add(item_)
                }
            }
        }

        if (indexOpers.isEmpty()){return this}
        var j:Int=0//indexOpers
        var i:Int=0
        while (i<=len){
            if (i==indexOpers[j]-1){
                listCalcNew.add(listCalcExpressions[j])
                i+=3
                if(j+1==indexOpers.size-1){
                    j++
                }
            }
            else{
                listCalcNew.add(this[i])
                i++
            }
        }
        this.clear()
        for(k in 0..<listCalcNew.count()){
            this.add(listCalcNew[k])
        }
        return listCalcNew
    }
    fun miniCalculate(list:MutableList<IManageItem>):Double{
        var sum:Double=((list[0] as ItemNumber).num).toDouble()
        for (i in 1..<list.count()-1 step 2){
            when{
                (list[i] as ItemOper).oper==EnumOperation.Plus -> sum+=((list[i+1] as ItemNumber).num).toDouble()
                (list[i] as ItemOper).oper==EnumOperation.Minus -> sum-=((list[i+1] as ItemNumber).num).toDouble()
                (list[i] as ItemOper).oper==EnumOperation.Multiply -> sum*=((list[i+1] as ItemNumber).num).toDouble()
                (list[i] as ItemOper).oper==EnumOperation.Divide -> sum/=((list[i+1] as ItemNumber).num).toDouble()
            }
        }
        return sum
    }
    fun Calculate(){
        this.HighPrioraCalc()
        var sum:Double=((this[0] as ItemNumber).num).toDouble()
        var len:Int=0
        if (this[this.count()-1] is ItemNumber){
            len=this.count()-1
        }
        else{len=this.count()-2 }
        for (i in 1..<len step 2){
            when{
                (this[i] as ItemOper).oper==EnumOperation.Plus -> sum+=((this[i+1] as ItemNumber).num).toDouble()
                (this[i] as ItemOper).oper==EnumOperation.Minus -> sum-=((this[i+1] as ItemNumber).num).toDouble()
                (this[i] as ItemOper).oper==EnumOperation.Multiply -> sum*=((this[i+1] as ItemNumber).num).toDouble()
                (this[i] as ItemOper).oper==EnumOperation.Divide -> sum/=((this[i+1] as ItemNumber).num).toDouble()
            }
        }
        showtxt.value=sum.toString()
        this.clear()
        this.AddSymbol(CalculatorAction.ActionSymbol(sum.toString()))
    }
}




