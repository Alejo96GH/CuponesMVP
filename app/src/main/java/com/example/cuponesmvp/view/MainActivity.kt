package com.example.cuponesmvp.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cuponesmvp.R
import com.example.cuponesmvp.presenter.CuponPresenterImpl
import com.example.cuponesmvp.model.Oferta
import com.example.cuponesmvp.presenter.CuponPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CuponView {

    private var cuponPresenter: CuponPresenter? = null
    private var listCupones:List<Oferta>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cuponPresenter =
            CuponPresenterImpl(this)

        getCupones()

    }

    fun getCupones(){
        cuponPresenter?.loadList()
    }

    override fun showErrorLoadCupon(message: String?) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showListCupones(cupones: List<Oferta>?) {
        this.listCupones = cupones
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false)
        val cuponesAdapter = CuponesAdapter(listCupones as ArrayList<Oferta>)
        recyclerView.adapter = cuponesAdapter
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }
}
