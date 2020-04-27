package com.example.cuponesmvp.model

import com.example.cuponesmvp.presenter.CuponPresenter

class CuponInteractorImpl (var cuponPresenter : CuponPresenter) : CuponInteractor {

    private var cuponRepository: CuponRepository = CuponRepositoryImpl(cuponPresenter)

    override fun loadList() {
        cuponRepository.loadList()
    }
}
