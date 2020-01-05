package com.oskarrek.it4animalcare.ui.advertisment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.AdvertisementModel

class NoticeBoardAdapter() : RecyclerView.Adapter<NoticeBoardAdapter.AdvertisementViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertisementViewHolder {
        return AdvertisementViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_advertisment, parent, false))
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: AdvertisementViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class AdvertisementViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(advertsement : AdvertisementModel) {
            itemView.apply {

            }
        }
    }
}