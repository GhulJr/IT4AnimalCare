package com.oskarrek.it4animalcare.ui.animal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.ui.animal.animals_list.AnimalsFragment

class AnimalsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animals_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AnimalsFragment.newInstance())
                .commitNow()
        }
    }

}
