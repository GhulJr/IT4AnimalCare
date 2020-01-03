package com.oskarrek.it4animalcare.ui.advertisment.fragments.notice_board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.ui.user.ViewModelUtils

class NoticeBoardFragment : Fragment() {

    private val noticeBoardViewModel =
        ViewModelUtils.instantiateViewModel<NoticeBoardViewModel>(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notice_board, container, false)
        return root
    }

    /** Utils */
}