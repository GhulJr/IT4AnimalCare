package com.oskarrek.it4animalcare.ui.common.deadlines_list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.oskarrek.it4animalcare.R

class DeadlinesFragment : Fragment() {

    companion object {
        fun newInstance() = DeadlinesFragment()
    }

    private lateinit var viewModel: DeadlinesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_deadlines, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DeadlinesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
