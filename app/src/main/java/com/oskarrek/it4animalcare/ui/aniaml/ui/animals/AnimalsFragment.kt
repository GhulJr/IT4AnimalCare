package com.oskarrek.it4animalcare.ui.aniaml.ui.animals

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oskarrek.it4animalcare.ui.aniaml.R

class AnimalsFragment : Fragment() {

    companion object {
        fun newInstance() = AnimalsFragment()
    }

    private lateinit var viewModel: AnimalsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.animals_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AnimalsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
