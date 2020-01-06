package com.oskarrek.it4animalcare.ui.advertisement.add_edit_advertisement.add_advertisement

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oskarrek.it4animalcare.R

class AddAdvertisementFragment : Fragment() {

    companion object {
        fun newInstance() =
            AddAdvertisementFragment()
    }

    private lateinit var viewModel: AddAdvertisementViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_add_advertosement, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddAdvertisementViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
