package com.oskarrek.it4animalcare.ui.main.notice_board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.util.DummyDataUtils
import com.oskarrek.it4animalcare.util.ViewModelUtils
import kotlinx.android.synthetic.main.fragment_notice_board.*
import kotlinx.android.synthetic.main.fragment_notice_board.view.*

class NoticeBoardFragment : Fragment() {

    private lateinit var noticeBoardViewModel : NoticeBoardViewModel

    private val noticeBoardAdapter = NoticeBoardAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notice_board, container, false)

        setupViewModel()
        setupRecyclerView(root)

        return root
    }


    /** Utils */
    private fun setupRecyclerView(root : View) {
        noticeBoardAdapter.advertisements = DummyDataUtils.getDummyAdvertisements()

        root.notice_board_recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = noticeBoardAdapter
        }
    }

    private fun setupViewModel() {
        noticeBoardViewModel = ViewModelUtils.createViewModel(this)
    }
}