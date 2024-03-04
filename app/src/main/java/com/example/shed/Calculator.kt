package com.example.shed

import android.content.ContentValues
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.shed.ui.theme.DBHelper


class Calculator : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel :CalculatorViewModel by viewModels()
        val state = viewModel.state
        var dbHelper:DBHelper =  DBHelper(this);
        val database = dbHelper.writableDatabase
        val contentValues = ContentValues()

        setContent {
            Creat(viewModel)
        }
    }
}


