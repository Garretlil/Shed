package com.example.shed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shed.ui.theme.DownGray
import com.example.shed.ui.theme.MediumGray
import com.example.shed.ui.theme.Orange
@Composable
fun Creat(viewModel:CalculatorViewModel){
    val buttonSpacing = 20.dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Text(
                text = viewModel.showtext.value ,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    color = Color.LightGray,

                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {

                    viewModel.onAction2(EnumCalculation.Clear)
                }
                CalculatorButton(

                    symbol = "Del",
                    color = Color.LightGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction2(EnumCalculation.Delete)
                }
                CalculatorButton(
                    symbol = "/",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionOperation(EnumOperation.Divide))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButtonNumber(
                    symbol = "7",
                    color = DownGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionSymbol("7"))
                }
                CalculatorButtonNumber(
                    symbol = "8",
                    color = DownGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionSymbol("8"))
                }
                CalculatorButtonNumber(
                    symbol = "9",
                    color = DownGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionSymbol("9"))
                }
                CalculatorButton(
                    symbol = "x",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionOperation(EnumOperation.Multiply))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButtonNumber(
                    symbol = "4",
                    color = DownGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionSymbol("4"))
                }
                CalculatorButtonNumber(
                    symbol = "5",
                    color = DownGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionSymbol("5"))
                }
                CalculatorButtonNumber(
                    symbol = "6",
                    color = DownGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionSymbol("6"))
                }
                CalculatorButton(
                    symbol = "-",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionOperation(EnumOperation.Minus))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButtonNumber(
                    symbol = "1",
                    color = DownGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionSymbol("1"))
                }
                CalculatorButtonNumber(
                    symbol = "2",
                    color = DownGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionSymbol("2"))
                }
                CalculatorButtonNumber(
                    symbol = "3",
                    color = DownGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionSymbol("3"))
                }
                CalculatorButton(
                    symbol = "+",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionOperation(EnumOperation.Plus))//для onClick
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButtonNumber(
                    symbol = "0",
                    color = DownGray,
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    viewModel.onAction(CalculatorAction.ActionSymbol("0"))
                }
                CalculatorButtonNumber(
                    symbol = ".",
                    color = DownGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction2(EnumCalculation.Decimal)
                }
                CalculatorButton(
                    symbol = "=",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction2(EnumCalculation.Calculate)
                }
            }
        }
    }
}