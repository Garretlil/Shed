package com.example.shed
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels


class Calculator : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel :CalculatorViewModel by viewModels()
        val state = viewModel.state

        setContent {
            Creat(viewModel)
        }
    }
}


