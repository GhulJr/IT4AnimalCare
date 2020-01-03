package com.oskarrek.it4animalcare.ui.advertisment.fragments.notice_board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.oskarrek.it4animalcare.R

class NoticeBoardFragment : Fragment() {

    private lateinit var noticeBoardViewModel: NoticeBoardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        noticeBoardViewModel =
            ViewModelProviders.of(this).get(NoticeBoardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notice_board, container, false)
        return root
    }
}