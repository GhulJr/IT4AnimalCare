package com.oskarrek.it4animalcare.ui.common.deadlines_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.DeadlineModel
import com.oskarrek.it4animalcare.ext.asDate
import com.oskarrek.it4animalcare.ui.main.notice_board.NoticeBoardAdapter
import kotlinx.android.synthetic.main.item_deadline.view.*


class DeadlinesAdapter : RecyclerView.Adapter<DeadlinesAdapter.DeadlineViewHolder>() {

    var deadlines = emptyList<DeadlineModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeadlineViewHolder {
        return DeadlineViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_deadline, parent, false)
        )
    }

    override fun getItemCount(): Int = deadlines.size

    override fun onBindViewHolder(holder: DeadlineViewHolder, position: Int) {
        holder.bind(deadlines[position])
    }


    class DeadlineViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item : DeadlineModel) {
            itemView.text_deadline.text = item.timeSpan.asDate("dd.MM.yy")
        }
    }
}