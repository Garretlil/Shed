package com.example.shed

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shed.ui.theme.anyColor

@Composable
fun ContentForButton(sign:String){
    Text(text="1", modifier = Modifier.background(anyColor))
}
@Composable
fun CreateButton4(count: MutableState<Int>,TEXT:String, color: Color) {
    val context = LocalContext.current
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()

        ) {
        Column(
            //modifier = Modifier.fillMaxSize().align(Alignment.Center),
            //verticalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            Button(
                onClick = {
                    count.value++
                },
                shape = CircleShape,
                colors = ButtonDefaults.outlinedButtonColors(color),
                //modifier = Modifier.padding(90.dp, 350.dp)
            )
            {
                Text(text = "4")
            }
            Button(
                onClick = {
                    count.value++
                },
                shape = CircleShape,
                colors = ButtonDefaults.outlinedButtonColors(color),
                // modifier = Modifier.padding(200.dp, 350.dp)
            )
            {
                Text(text = "8")
            }
        }
    }
}
@Composable
fun HomeScreenText(count: MutableState<Int>)
{
    val counterValue = count.value
    Row() {

        Text(
            text = "Clicks: $counterValue",
            textAlign = TextAlign.Center,
            modifier = Modifier.background(color = Color.LightGray)
        )
    }
}

