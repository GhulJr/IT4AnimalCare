package com.oskarrek.it4animalcare.ui.main.notice_board

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.AdvertisementModel
import com.oskarrek.it4animalcare.ui.advertisement.advertisement_details.AdvertisementDetailsActivity
import com.oskarrek.it4animalcare.util.ViewModelUtils
import kotlinx.android.synthetic.main.fragment_notice_board.view.*

class NoticeBoardFragment : Fragment() {
    companion object {
        fun newInstance() = NoticeBoardFragment()
        val SERIALIZABLE_ADVERTISEMENT =
            "SERIALIZABLE_ADVERTISEMENT" //TODO: move it somewhere else (utils for example)
    }

    private lateinit var noticeBoardViewModel: NoticeBoardViewModel

    private lateinit var noticeBoardAdapter: NoticeBoardAdapter

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

    private fun setupRecyclerView(root: View) {
        noticeBoardAdapter = NoticeBoardAdapter { startAdvertisementDetailsIntent(it) }

        root.notice_board_recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = noticeBoardAdapter
        }
    }

    private fun setupViewModel() {
        noticeBoardViewModel = ViewModelUtils.createViewModel(this)
        noticeBoardViewModel.advertsements.observe(this, Observer {list ->
            noticeBoardAdapter.apply {
                advertisements = list
                notifyDataSetChanged()
            }
        })
    }

    private fun startAdvertisementDetailsIntent(advertisement: AdvertisementModel) {
        val intent = Intent(context, AdvertisementDetailsActivity::class.java)
        intent.putExtra(SERIALIZABLE_ADVERTISEMENT, advertisement) // TODO: pass whole object
        startActivity(intent)
    }
}