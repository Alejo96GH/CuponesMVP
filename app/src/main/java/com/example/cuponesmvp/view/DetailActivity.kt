package com.example.cuponesmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cuponesmvp.R
import com.example.cuponesmvp.model.Oferta
import com.example.cuponesmvp.presenter.DetailPresenter
import com.example.cuponesmvp.presenter.DetailPresenterImpl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() , DetailView{

    private var detailPresenter: DetailPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

        detailPresenter = DetailPresenterImpl(this)
        val cupon = intent?.getSerializableExtra("Cupon") as Oferta
        getCupon(cupon)
    }

    fun getCupon(cupon: Oferta) {
        detailPresenter?.loadCupon(cupon)
    }

    override fun cargarCupon(cupon: Oferta) {
        tv_title.text = cupon.title
        tv_estado.text = "Estado: " + cupon.status
        tv_identificacion.text = "Identificación: " + cupon.lmdId
        tv_tienda.text = "Tienda: " + cupon.store
        tv_oferta.text = "Tipo de oferta: " + cupon.offerValue
        tv_link.text = "Link: " + cupon.smartLink

        if(!cupon.imageUrl.isNullOrEmpty()) {
            Picasso.get().load(cupon.imageUrl).into(iv_picture)
        }
    }
}
