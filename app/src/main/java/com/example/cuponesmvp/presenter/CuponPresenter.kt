package com.example.cuponesmvp.presenter

import com.example.cuponesmvp.model.Oferta

interface CuponPresenter {
    fun loadList()
    fun showErrorLoadCupon(message: String?)
    fun sendListCupones(cupones: List<Oferta>?)
}