package com.example.tic_tac_toe

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tic_tac_toe.ui.theme.TicTacToeTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
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
                val viewModel = viewModel<GameViewModel>()
                    GameScreen(
                        viewModel = viewModel
                    )
            }
        }
    }

}