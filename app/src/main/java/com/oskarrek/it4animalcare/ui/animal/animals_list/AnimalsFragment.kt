package com.oskarrek.it4animalcare.ui.animal.animals_list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.ui.advertisement.advertisement_details.AdvertisementDetailsActivity
import com.oskarrek.it4animalcare.ui.common.deadlines_list.DeadlinesAdapter
import com.oskarrek.it4animalcare.util.ViewModelUtils
import kotlinx.android.synthetic.main.fragment_animals.view.*
import kotlinx.android.synthetic.main.fragment_deadlines.view.*
import java.io.Serializable

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
        setupViewModel()
        val id = arguments?.getInt(AdvertisementDetailsActivity.ADVERTISEMENT_ID) ?: -1
        viewModel.getDeadlines(id)
        return root
    }

    private fun setupViewModel() {
        viewModel = ViewModelUtils.createViewModel(this)

        viewModel.animals.observe(this, Observer {list ->
            animalsAdapter.apply {
                animals = list
                notifyDataSetChanged()
            }
        })
    }

    private fun setupRecyclerView(root: View) {
        animalsAdapter = AnimalsAdapter()

        root.animals_recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = animalsAdapter
        }
    }


}
