package com.example.tic_tac_toe

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tic_tac_toe.ui.theme.TicTacToeTheme


class MainActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {

            }
        }
    }

}