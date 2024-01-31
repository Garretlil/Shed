package com.example.shed

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HomeScreenBox(checked: State<Boolean>,
                  onCheckedChange: (Boolean) -> Unit){
    val checkedValue = checked.value
    var text:String
    if (checked.value) {
        text ="checkbox is on"
    }
    else{text="checkbox is off"}
    Column(verticalArrangement = Arrangement.Center) {
        Checkbox(checked = checkedValue, onCheckedChange = onCheckedChange)
        Text(text=text)
    }
}

