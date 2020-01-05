package com.oskarrek.it4animalcare.ui.offer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.ui.offer.offers.OffersFragment

class OffersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.offers_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, OffersFragment.newInstance())
                .commitNow()
        }
    }

}
