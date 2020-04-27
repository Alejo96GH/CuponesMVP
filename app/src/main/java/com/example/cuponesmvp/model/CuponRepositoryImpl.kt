package com.example.cuponesmvp.model

import com.example.cuponesmvp.presenter.CuponPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CuponRepositoryImpl(var cuponPresenter : CuponPresenter): CuponRepository {

    override fun loadList() {
        val API_KEY = "25fb8437ab8853357111dc2b6f29cfb0"

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