package com.oskarrek.it4animalcare.ui.animal.animals_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.AnimalModel
import com.oskarrek.it4animalcare.data.model.DeadlineModel

class AnimalsAdapter : RecyclerView.Adapter<AnimalsAdapter.AnimalViewHolder>(){

    var animals = emptyList<AnimalModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_deadline, parent, false)
        )
    }

    override fun getItemCount(): Int = animals.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animals[position])
    }


    class AnimalViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item : AnimalModel) {
        }
    }
}