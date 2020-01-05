package com.oskarrek.it4animalcare.ui.main.notice_board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.AdvertisementModel
import com.oskarrek.it4animalcare.ext.asString
import kotlinx.android.synthetic.main.item_advertisement.view.*

class NoticeBoardAdapter : RecyclerView.Adapter<NoticeBoardAdapter.AdvertisementViewHolder>() {

    var advertisements : List<AdvertisementModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertisementViewHolder {
        return AdvertisementViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_advertisement, parent, false)
        )
    }

    override fun getItemCount(): Int = advertisements.size

    override fun onBindViewHolder(holder: AdvertisementViewHolder, position: Int) {
        val item = advertisements[position]
        holder.bind(item)
    }

    class AdvertisementViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(advertisement : AdvertisementModel) {
            itemView.apply {
                notice_board_title.text = advertisement.title
                notice_board_animals.text = advertisement.care.toString()
                notice_board_deadlines.text = advertisement.deadlines.asString()
                notice_board_localisation.text = advertisement.localisation.toString()
            }
        }
    }
}