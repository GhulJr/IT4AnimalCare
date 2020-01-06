package com.oskarrek.it4animalcare.ui.animal.animals_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.AnimalModel
import com.oskarrek.it4animalcare.data.model.DeadlineModel
import com.oskarrek.it4animalcare.ext.getSex
import kotlinx.android.synthetic.main.item_animal.view.*

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
            itemView.animal_name.text = item.name
            itemView.animal_species.text = item.species
            itemView.animal_age.text = "Wiek: ${item.age}"
            itemView.animal_sex.setText(item.getSex())
        }
    }
}