package com.oskarrek.it4animalcare.ui.animal.animals_list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.ui.common.deadlines_list.DeadlinesAdapter
import com.oskarrek.it4animalcare.util.ViewModelUtils
import kotlinx.android.synthetic.main.fragment_animals.view.*
import kotlinx.android.synthetic.main.fragment_deadlines.view.*

class AnimalsFragment : Fragment() {

    companion object {
        fun newInstance() = AnimalsFragment()
    }

    private lateinit var viewModel: AnimalsViewModel
    private lateinit var animalsAdapter: AnimalsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_animals, container, false)
        setupRecyclerView(root)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelUtils.createViewModel(this)
    }

    private fun setupRecyclerView(root: View) {
        animalsAdapter = AnimalsAdapter()

        root.animals_recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = animalsAdapter
        }
    }

}
