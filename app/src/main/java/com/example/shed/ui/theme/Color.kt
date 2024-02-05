package com.example.shed.ui.theme

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val MediumGray = Color(0xFF2E2E2E)
val DownGray = Color(0x61818181)
val Orange = Color(0xFFFF9800)
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