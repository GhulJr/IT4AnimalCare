package com.oskarrek.it4animalcare.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.ui.user.user.UserFragment

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UserFragment.newInstance())
                .commitNow()
        }
    }

}
