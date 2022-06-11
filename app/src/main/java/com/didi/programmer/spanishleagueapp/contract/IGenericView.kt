package com.didi.programmer.spanishleagueapp.contract

abstract interface IGenericView {
    fun showLoading()
    fun hideLoading()
    fun showAlert(message: String)
}