package com.oskarrek.it4animalcare.util

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

object ViewModelUtils {

    inline fun <reified T : ViewModel>createViewModel(fragment : Fragment) : T {
        return ViewModelProviders.of(fragment).get(T::class.java)
    }

    inline fun <reified T : ViewModel>createViewModel(activity : FragmentActivity) : T {
        return ViewModelProviders.of(activity).get(T::class.java)
    }

}