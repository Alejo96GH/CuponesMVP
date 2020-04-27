package com.example.cuponesmvp.view

import com.example.cuponesmvp.model.Oferta

interface CuponView {
    fun showProgressBar()
    fun showErrorLoadCupon(message: String?)
    fun showListCupones (cupones: List<Oferta>?)
    fun hideProgressBar()
}