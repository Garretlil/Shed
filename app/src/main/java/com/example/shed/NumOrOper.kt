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

   // override fun Get() :String{
   //     return num
   // }

}
class ItemOper():IManageItem{
    var oper:EnumOperation=EnumOperation("")
    override fun Add(symbol: String) {}
    override fun Delete() {}
   // override fun Get() :String{
   //     when(){
   //
   //     }
   // }

}
