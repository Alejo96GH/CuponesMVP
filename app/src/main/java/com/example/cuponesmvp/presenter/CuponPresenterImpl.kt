package com.example.cuponesmvp.presenter

import com.example.cuponesmvp.model.CuponInteractor
import com.example.cuponesmvp.model.CuponInteractorImpl
import com.example.cuponesmvp.model.Oferta
import com.example.cuponesmvp.view.CuponView

class CuponPresenterImpl (var cuponView: CuponView) : CuponPresenter {

    private var cuponInteractor: CuponInteractor = CuponInteractorImpl(this)


    override fun loadList() {
        cuponInteractor.loadList()
    }

    override fun showErrorLoadCupon(message: String?) {
        cuponView.showErrorLoadCupon(message)
    }

    override fun sendListCupones(cupones: List<Oferta>?) {
        cuponView.showListCupones(cupones)
    }
}