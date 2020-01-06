package com.oskarrek.it4animalcare.ui.advertisement.users_advertisements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.ui.advertisement.users_advertisements.advertisements.UserAdvertisementsFragment

class UserAdvertisementsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_advertisements)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UserAdvertisementsFragment.newInstance())
                .commitNow()
        }
    }

}
