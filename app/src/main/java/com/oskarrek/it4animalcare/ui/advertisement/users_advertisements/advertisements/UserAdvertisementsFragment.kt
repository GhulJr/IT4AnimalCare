package com.oskarrek.it4animalcare.ui.advertisement.users_advertisements.advertisements

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oskarrek.it4animalcare.R

class UserAdvertisementsFragment : Fragment() {

    companion object {
        fun newInstance() =
            UserAdvertisementsFragment()
    }

    private lateinit var viewModel: UserAdvertisementsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.my_advertisements_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserAdvertisementsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
