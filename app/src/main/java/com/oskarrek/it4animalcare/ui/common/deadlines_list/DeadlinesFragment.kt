package com.oskarrek.it4animalcare.ui.common.deadlines_list

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.ui.advertisement.advertisement_details.AdvertisementDetailsActivity.Companion.ADVERTISEMENT_ID
import com.oskarrek.it4animalcare.util.ViewModelUtils
import kotlinx.android.synthetic.main.fragment_deadlines.view.*

@RequiresApi(Build.VERSION_CODES.N)
class DeadlinesFragment : Fragment() {

    companion object {
        fun newInstance() = DeadlinesFragment()
    }

    private lateinit var viewModel: DeadlinesViewModel
    private lateinit var deadlinesAdapter: DeadlinesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_deadlines, container, false)
        setupRecyclerView(root)
        setupViewModel()
        val id = arguments?.getInt(ADVERTISEMENT_ID) ?: -1
        viewModel.getDeadlines(id)
        return root
    }

    private fun setupViewModel() {
        viewModel = ViewModelUtils.createViewModel(this)

        viewModel.deadlines.observe(this, Observer {list ->
            deadlinesAdapter.apply {
                deadlines = list
                notifyDataSetChanged()
            }
        })
    }

    private fun setupRecyclerView(root: View) {
        deadlinesAdapter = DeadlinesAdapter()


        root.deadlines_recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = deadlinesAdapter
        }
    }

}
