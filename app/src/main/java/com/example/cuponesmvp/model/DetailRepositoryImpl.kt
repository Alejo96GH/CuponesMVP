package com.example.cuponesmvp.model

import com.example.cuponesmvp.presenter.DetailPresenter

class DetailRepositoryImpl(var descriptionPresenter: DetailPresenter) : DetailRepository {
    override fun loadcupon(cupon: Oferta) {
        descriptionPresenter.cargarCupon(cupon)
    }
}