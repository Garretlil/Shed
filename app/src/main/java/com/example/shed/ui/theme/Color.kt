package com.example.shed.ui.theme

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

val anyColor= Color(0xEDFFFFFF)
val GrayColor = Color.Blue//numbers
//val GreenColor = Color.Green//operators
val YellowColor=Color.Yellow//equal
//val RedColor=Color.Red//buttonClear
val LightGrayColor=Color.LightGray//operators
val Pink = Color(0XFFFB78A6)


val ResultShadowColorTop = Color(0x0DFFFFFF)
val ResultShadowColorBottom = Color(0x4D000000)
val ButtonShadowColorTop = Color(0x40FFFFFF)
val ButtonShadowColorBottom = Color(0X2E000000)

val ButtonPink = Color(0XFFFB78A6)
val ButtonBlue = Color(0xFF78FBBE)
val ButtonYellow = Color(0XFFE9D30E)

public fun randomColor(): Int {
    return Random.nextInt(0, 225)
}