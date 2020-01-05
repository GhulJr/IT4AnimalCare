package com.oskarrek.it4animalcare.ui.aniaml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oskarrek.it4animalcare.ui.aniaml.ui.animals.AnimalsFragment

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
