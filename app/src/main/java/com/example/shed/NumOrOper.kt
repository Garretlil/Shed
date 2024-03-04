package com.example.shed

interface IManageItem {

    fun Delete(){}
    fun Add(symbol:String){}
    //fun Get():String{}
}

class ItemNumber:IManageItem{
    var num: String=""
    override fun Add(symbol:String){
        num+=symbol
    }

    override fun Delete() {
        num=num.dropLast(1)
    }
}
class ItemOper():IManageItem{
    var oper:EnumOperation=EnumOperation("",-1)
    override fun Add(symbol: String) {}
    override fun Delete() {}

}
