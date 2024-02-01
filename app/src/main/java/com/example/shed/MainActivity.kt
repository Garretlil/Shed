package com.example.shed
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shed.ui.theme.*

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val counter = mutableStateOf(0)
        val checked =mutableStateOf(true)
        val viewModel :CalculatorViewModel by viewModels()
        val state = viewModel.state
        val buttonSpacing = 8.dp
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    verticalArrangement = Arrangement.spacedBy(buttonSpacing),
                ) {
                    Text(
                        text = viewModel.state.number1 + (viewModel.state.operation?.symbol ?: "") + viewModel.state.number2,
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
                            color = LightGray,

                            modifier = Modifier
                                .aspectRatio(2f)
                                .weight(2f)
                        ) {
                            viewModel.onAction(CalculatorAction.Clear)
                        }
                        CalculatorButton(

                            symbol = "Del",
                            color = LightGray,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Delete)
                        }
                        CalculatorButton(
                            symbol = "/",
                            color = Orange,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                    ) {
                        CalculatorButton(
                            symbol = "7",
                            color = MediumGray,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(7))
                        }
                        CalculatorButton(
                            symbol = "8",
                            color = MediumGray,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(8))
                        }
                        CalculatorButton(
                            symbol = "9",
                            color = MediumGray,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(9))
                        }
                        CalculatorButton(
                            symbol = "x",
                            color = Orange,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                    ) {
                        CalculatorButton(
                            symbol = "4",
                            color = MediumGray,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(4))
                        }
                        CalculatorButton(
                            symbol = "5",
                            color = MediumGray,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(5))
                        }
                        CalculatorButton(
                            symbol = "6",
                            color = MediumGray,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(6))
                        }
                        CalculatorButton(
                            symbol = "-",
                            color = Orange,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Minus))
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                    ) {
                        CalculatorButton(
                            symbol = "1",
                            color = MediumGray,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(1))
                        }
                        CalculatorButton(
                            symbol = "2",
                            color = MediumGray,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(2))
                        }
                        CalculatorButton(
                            symbol = "3",
                            color = MediumGray,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(3))
                        }
                        CalculatorButton(
                            symbol = "+",
                            color = Orange,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Plus))//для onClick
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                    ) {
                        CalculatorButton(
                            symbol = "0",
                            color = MediumGray,
                            modifier = Modifier
                                .aspectRatio(2f)
                                .weight(2f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(0))
                        }
                        CalculatorButton(
                            symbol = ".",
                            color = MediumGray,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Decimal)
                        }
                        CalculatorButton(
                            symbol = "=",
                            color = Orange,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Calculate)
                        }
                    }
                }
            }
        }
    }
}


