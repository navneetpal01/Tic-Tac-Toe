package com.example.tic_tac_toe


sealed class UserAction{
    object PlayAgainButtonClick : UserAction()
    data class BoardTapped(val cellNo : Int) : UserAction()
}