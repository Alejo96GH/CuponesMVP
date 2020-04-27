package com.example.cuponesmvp.model

import com.example.cuponesmvp.presenter.CuponPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CuponRepositoryImpl(var cuponPresenter : CuponPresenter): CuponRepository {

    override fun loadList() {
        val API_KEY = "cf6373ed8e5e287536a8fe699997c3b5"

        ApiService.create()
            .getTopRated(API_KEY)
            .enqueue(object : Callback<Cupones> {
                override fun onFailure(call: Call<Cupones>, t: Throwable) {
                    cuponPresenter.showErrorLoadCupon(t.message)
                }

                override fun onResponse(call: Call<Cupones>, response: Response<Cupones>) {
                    if (response.isSuccessful) {
                        cuponPresenter.sendListCupones(response.body()?.offers)
                    }
                }
            })
    }
}