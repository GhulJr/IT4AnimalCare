package com.oskarrek.it4animalcare.ui.advertisement.advertisement_details

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.AdvertisementModel
import com.oskarrek.it4animalcare.ext.asDate
import com.oskarrek.it4animalcare.ui.animal.animals_list.AnimalsFragment
import com.oskarrek.it4animalcare.ui.common.deadlines_list.DeadlinesFragment
import com.oskarrek.it4animalcare.ui.main.notice_board.NoticeBoardFragment
import com.oskarrek.it4animalcare.ui.main.notice_board.NoticeBoardFragment.Companion.SERIALIZABLE_ADVERTISEMENT
import com.oskarrek.it4animalcare.util.ViewModelUtils
import kotlinx.android.synthetic.main.activity_advertisement_details.*
import kotlinx.android.synthetic.main.content_advertisement_details.*
import kotlinx.android.synthetic.main.content_toolbar_advertisement_details.view.*

class AdvertisementDetailsActivity : AppCompatActivity() {

    lateinit var viewModel : AdvertisementDetailsViewModel

    companion object {
        val ADVERTISEMENT_ID = "ADVERTISEMENT_ID" //TODO: put it to utils.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertisement_details)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        setupViewModel()
        handleIntent()
        setupFragments(savedInstanceState)
    }

    private fun handleIntent() {
        if(intent.hasExtra(SERIALIZABLE_ADVERTISEMENT)) {
            viewModel.advertisementModel = intent.getSerializableExtra(SERIALIZABLE_ADVERTISEMENT) as AdvertisementModel
            bind()
        }
    }

    private fun bind() {
        toolbar_layout.advertisement_title.text = viewModel.advertisementModel.title
        toolbar_layout.added_date.text = viewModel.advertisementModel.addedTimeSpan.asDate("dd.MM.yy")
        toolbar_layout.expiration_date.text = viewModel.advertisementModel.expirationTimeSpan?.asDate("dd.MM.yy")
        advertisement_contents.text = viewModel.advertisementModel.contents
    }

    private fun setupFragments(savedInstanceState: Bundle?) {
       if (savedInstanceState == null) {
           val bundle = Bundle()
               .apply {putInt(ADVERTISEMENT_ID, viewModel.advertisementModel.id)}


            supportFragmentManager.beginTransaction()
                .replace(R.id.deadlines_container, DeadlinesFragment.newInstance()
                    .apply { arguments = bundle })
                .commitNow()

           supportFragmentManager.beginTransaction()
               .replace(R.id.animals_container, AnimalsFragment.newInstance()
                   .apply { arguments = bundle })
               .commitNow()
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelUtils.createViewModel(this)
    }
}
