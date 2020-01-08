package com.oskarrek.it4animalcare.ui.login.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.UserModel
import com.oskarrek.it4animalcare.data.model.request.RegisterRequest
import com.oskarrek.it4animalcare.util.RequestUtils
import com.oskarrek.it4animalcare.util.ViewModelUtils

class RegisterActivity : AppCompatActivity() {

    lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelUtils.createViewModel(this)
        viewModel.registerResult.observe(this, Observer {
            if(it == null) {
                Toast.makeText(this, "Podany login jest już zajęty.", Toast.LENGTH_LONG).show()
            }
            else if(it.resultCode == RequestUtils.RESULTCODE_SUCCESS) {
                finish()
            }
        })
        viewModel.registerUser(RegisterRequest("req98", "paputki", "paputek", 123456789, "email@domena.com"))
    }
}
