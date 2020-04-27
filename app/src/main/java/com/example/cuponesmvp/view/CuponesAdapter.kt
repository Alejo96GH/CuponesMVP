package com.example.cuponesmvp.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cuponesmvp.R
import com.example.cuponesmvp.model.Oferta
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cupon_list_item.view.*

class CuponesAdapter(cuponesList: ArrayList<Oferta>) :
    RecyclerView.Adapter<CuponesAdapter.CuponesViewHolder>() {

    private var cuponesList = ArrayList<Oferta>()

    init {
        this.cuponesList = cuponesList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuponesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cupon_list_item, parent, false)
        return CuponesViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int = cuponesList.size

    override fun onBindViewHolder(holder: CuponesViewHolder, position: Int) {
        val cupon = cuponesList[position]
        holder.setCupon(cupon)
    }

    class CuponesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var cupon: Oferta? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setCupon(cupon: Oferta){
                this.cupon = cupon

                itemView.tv_title.text = cupon.title + " (" + cupon.offerValue + ")"
                itemView.tv_estado.text = "Estado: " + cupon.status
                itemView.tv_identificacion.text = "Identificación: " + cupon.lmdId
                itemView.tv_tienda.text = "Tienda: " + cupon.store

                if(!cupon.imageUrl.isNullOrEmpty()) {
                    Picasso.get().load(cupon.imageUrl).into(itemView.iv_picture)
                }
        }

        override fun onClick(v: View) {
         val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra("Cupon", cupon)
            itemView.context.startActivity(intent)
        }
    }
}