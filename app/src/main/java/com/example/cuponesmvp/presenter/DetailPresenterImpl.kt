package com.example.cuponesmvp.presenter

import com.example.cuponesmvp.model.DetailInteractor
import com.example.cuponesmvp.model.DetailInteractorImpl
import com.example.cuponesmvp.model.Oferta
import com.example.cuponesmvp.view.DetailView

class DetailPresenterImpl(var detailView: DetailView): DetailPresenter {

  private var detailInteractor : DetailInteractor = DetailInteractorImpl(this)
  override fun cargarCupon(cupon: Oferta) {
      detailView.cargarCupon(cupon)
  }

  override fun loadCupon(cupon: Oferta) {
      detailInteractor.loadCupon(cupon)
  }
}