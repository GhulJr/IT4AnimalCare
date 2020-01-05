package com.oskarrek.it4animalcare.ui.user

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.oskarrek.it4animalcare.ui.advertisment.fragments.notice_board.NoticeBoardFragment
import com.oskarrek.it4animalcare.ui.advertisment.fragments.notice_board.NoticeBoardViewModel

object ViewModelUtils {

    inline fun <reified T : ViewModel>instantiateViewModel(fragment : Fragment) : T {
        return ViewModelProviders.of(fragment).get(T::class.java)
    }

    inline fun <reified T : ViewModel>instantiateViewModel(activity : FragmentActivity) : T {
        return ViewModelProviders.of(activity).get(T::class.java)
    }

}