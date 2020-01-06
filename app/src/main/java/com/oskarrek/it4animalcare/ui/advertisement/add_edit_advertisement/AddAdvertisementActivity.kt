package com.oskarrek.it4animalcare.ui.advertisement.add_edit_advertisement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.ui.advertisement.add_edit_advertisement.add_advertisement.AddAdvertisementFragment

class AddAdvertisementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_advertosement)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AddAdvertisementFragment.newInstance())
                .commitNow()
        }
    }

}
