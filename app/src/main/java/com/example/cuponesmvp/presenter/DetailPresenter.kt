package com.example.cuponesmvp.presenter

import com.example.cuponesmvp.model.Oferta

interface DetailPresenter {
    fun cargarCupon(cupon: Oferta)
    fun loadCupon(cupon: Oferta)
}