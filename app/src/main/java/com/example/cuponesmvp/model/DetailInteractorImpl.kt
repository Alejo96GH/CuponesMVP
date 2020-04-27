package com.example.cuponesmvp.model

import com.example.cuponesmvp.presenter.DetailPresenter


class DetailInteractorImpl(var detailPresenter: DetailPresenter) : DetailInteractor {

    private var detailRepository: DetailRepository = DetailRepositoryImpl(detailPresenter)

    override fun loadCupon(cupon: Oferta) {
        detailRepository.loadcupon(cupon)
    }


}