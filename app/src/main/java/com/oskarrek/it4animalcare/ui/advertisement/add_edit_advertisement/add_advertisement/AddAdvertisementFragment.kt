package com.oskarrek.it4animalcare.ui.advertisement.add_edit_advertisement.add_advertisement

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.ui.advertisement.advertisement_details.AdvertisementDetailsActivity
import com.oskarrek.it4animalcare.ui.animal.animals_list.AnimalsFragment
import com.oskarrek.it4animalcare.ui.common.deadlines_list.DeadlinesFragment

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
        setupFragments(savedInstanceState)
    }
    private fun setupFragments(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            //val bundle = Bundle().apply {putInt(AdvertisementDetailsActivity.ADVERTISEMENT_ID, viewModel.advertisementModel.id)}


            childFragmentManager.beginTransaction()
                .replace(R.id.deadlines_container, DeadlinesFragment.newInstance())
                .commitNow()

            childFragmentManager.beginTransaction()
                .replace(R.id.animals_container, AnimalsFragment.newInstance())
                .commitNow()
        }
    }


}
