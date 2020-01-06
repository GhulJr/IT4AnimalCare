package com.oskarrek.it4animalcare.ui.common.deadlines_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.util.ViewModelUtils
import kotlinx.android.synthetic.main.fragment_deadlines.view.*
import kotlinx.android.synthetic.main.fragment_notice_board.view.*

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
        deadlinesAdapter = DeadlinesAdapter()


        root.deadlines_recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = deadlinesAdapter
        }
    }

}
