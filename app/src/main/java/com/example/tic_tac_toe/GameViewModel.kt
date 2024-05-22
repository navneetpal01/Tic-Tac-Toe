package com.example.tic_tac_toe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.BoardCellValue
import com.example.GameState
import com.example.VictoryType


class GameViewModel : ViewModel() {

    var state by mutableStateOf(GameState())

    val boardItems: MutableMap<Int, BoardCellValue> = mutableMapOf(
        1 to BoardCellValue.NONE,
        2 to BoardCellValue.NONE,
        3 to BoardCellValue.NONE,
        4 to BoardCellValue.NONE,
        5 to BoardCellValue.NONE,
        6 to BoardCellValue.NONE,
        7 to BoardCellValue.NONE,
        8 to BoardCellValue.NONE,
        9 to BoardCellValue.NONE,
    )

    fun onAction(action: UserAction) {
        when (action) {
            is UserAction.BoardTapped -> {
                addValuesToBoard(action.cellNo)
            }

            UserAction.PlayAgainButtonClick -> {
                gameReset()
            }

        }

    }

    private fun addValuesToBoard(cellNo: Int) {
        if (boardItems[cellNo] != BoardCellValue.NONE) {
            return
        }
        if (state.currentTurn == BoardCellValue.CIRCLE) {
            boardItems[cellNo] = BoardCellValue.CIRCLE
            if (checkForVictory(BoardCellValue.CIRCLE)){

            }
            if (hasBoardFull()) {
                state = state.copy(
                    hintText = "Game Draw",
                    drawCount = state.drawCount + 1
                )
            } else {
                state = state.copy(
                    hintText = "Player 'X' turn",
                    currentTurn = BoardCellValue.CROSS
                )
            }
        } else if (state.currentTurn == BoardCellValue.CROSS) {
            boardItems[cellNo] = BoardCellValue.CROSS
            if (hasBoardFull()) {
                state = state.copy(
                    hintText = "Game Draw",
                    drawCount = state.drawCount + 1
                )
            } else {
                state = state.copy(
                    hintText = "Player '0' turn",
                    currentTurn = BoardCellValue.CIRCLE
                )
            }
        }
    }


    private fun checkForVictory(boardValue : BoardCellValue) : Boolean{
        when{
            boardItems[1] == boardValue && boardItems[2] == boardValue && boardItems[3] == boardValue ->{
                state = state.copy(victoryType = VictoryType.HORIZONTAL1)
                return true
            }

        }
    }

    private fun hasBoardFull(): Boolean {
        if (boardItems.containsValue(BoardCellValue.NONE)) return false
        else return true
    }

    private fun gameReset(){
        boardItems.forEach{ (i, _) ->
            boardItems[i] = BoardCellValue.NONE
        }
        state = state.copy(
            hintText = "Player '0' turn",
            currentTurn = BoardCellValue.CIRCLE,
            victoryType = VictoryType.NONE,
            hasWon = false
        )
    }



}