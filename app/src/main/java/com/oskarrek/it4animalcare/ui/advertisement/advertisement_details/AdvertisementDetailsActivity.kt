package com.oskarrek.it4animalcare.ui.advertisement.advertisement_details

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.ui.main.notice_board.NoticeBoardFragment.Companion.SERIALIZABLE_ADVERTISEMENT
import kotlinx.android.synthetic.main.activity_advertisement_details.*
import kotlinx.android.synthetic.main.content_toolbar_advertisement_details.view.*

class AdvertisementDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertisement_details)
        //setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        handleIntent()
    }

    private fun handleIntent() {
        if(intent.hasExtra(SERIALIZABLE_ADVERTISEMENT)) {
            toolbar_layout.advertisement_title.text = intent.getStringExtra(SERIALIZABLE_ADVERTISEMENT)
        }
    }
}
