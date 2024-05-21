package com.example.tic_tac_toe

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BoardBase() {


    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp),
        onDraw = {
            drawLine(
                color = Color.Gray,
                strokeWidth = 5f,
                cap = StrokeCap.Round,
                start = Offset(
                    x = size.width * 1/3,
                    y = 0f
                ),
                end = Offset(
                    x = size.width * 1/3,
                    y = size.height
                )
            )
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewBoardBase(){
    BoardBase()
}