package com.oskarrek.it4animalcare.ui.main.notice_board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.AdvertisementModel
import com.oskarrek.it4animalcare.ext.asDate
import com.oskarrek.it4animalcare.ext.asString
import kotlinx.android.synthetic.main.item_advertisement.view.*

class NoticeBoardAdapter(private val clickListener : (AdvertisementModel) -> (Unit) )
    : RecyclerView.Adapter<NoticeBoardAdapter.AdvertisementViewHolder>() {

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
        holder.bind(item, clickListener)
    }

    //TODO: refactor this to data binding library.
    class AdvertisementViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item : AdvertisementModel, clickListener: (AdvertisementModel) -> Unit) {
            itemView.apply {
                notice_board_title.text = item.title
                notice_board_animals.text = item.addedTimeSpan.asDate("dd.MM.yy")
                notice_board_deadlines.text = item.expirationTimeSpan?.asDate("dd.MM.yy")
                notice_board_localisation.text = item.localisation.toString()

                setOnClickListener {clickListener(item)}
            }
        }
    }
}