package com.oskarrek.it4animalcare.ui.login.register

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.UserModel
import com.oskarrek.it4animalcare.data.model.request.RegisterRequest
import com.oskarrek.it4animalcare.ui.login.afterTextChanged
import com.oskarrek.it4animalcare.ui.main.MainActivity.Companion.LOGIN
import com.oskarrek.it4animalcare.ui.main.MainActivity.Companion.PASSWORD
import com.oskarrek.it4animalcare.ui.main.MainActivity.Companion.USER
import com.oskarrek.it4animalcare.util.RequestUtils
import com.oskarrek.it4animalcare.util.ViewModelUtils
import kotlinx.android.synthetic.main.content_register.*

class RegisterActivity : AppCompatActivity() {


    lateinit var viewModel: RegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Views.
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val nick = findViewById<EditText>(R.id.nick)
        val email = findViewById<EditText>(R.id.email)
        val phoneNumber = findViewById<EditText>(R.id.phone_number)

        //View model.
        viewModel = ViewModelUtils.createViewModel(this)
        viewModel.registerResult.observe(this, Observer {
            if(it == null) {
                Toast.makeText(this, "Podany login jest już zajęty lub podano błędny email.", Toast.LENGTH_LONG).show()
            }
            else if(it.resultCode == RequestUtils.RESULTCODE_SUCCESS) {
                val intent = Intent()
                intent.putExtra(USER, UserModel(
                    username.text.toString(),
                    password.text.toString(),
                    nick.text.toString(),
                    phoneNumber.text.toString().toInt(),
                    email.text.toString()))
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        })

        viewModel.isValid.observe(this, Observer{isValid ->
            btn_register.isEnabled = isValid
        })

        //TextChange.
        username.afterTextChanged {
            viewModel.registerDataChanged(
                username.text.toString(),
                password.text.toString(),
                nick.text.toString(),
                phoneNumber.text.toString(),
                email.text.toString())
        }

        password.afterTextChanged {
            viewModel.registerDataChanged(
                username.text.toString(),
                password.text.toString(),
                nick.text.toString(),
                phoneNumber.text.toString(),
                email.text.toString())
        }

        nick.afterTextChanged {
            viewModel.registerDataChanged(
                username.text.toString(),
                password.text.toString(),
                nick.text.toString(),
                phoneNumber.text.toString(),
                email.text.toString())
        }

        email.afterTextChanged {
            viewModel.registerDataChanged(
                username.text.toString(),
                password.text.toString(),
                nick.text.toString(),
                phoneNumber.text.toString(),
                email.text.toString())
        }

        phoneNumber.afterTextChanged {
            viewModel.registerDataChanged(
                username.text.toString(),
                password.text.toString(),
                nick.text.toString(),
                phoneNumber.text.toString(),
                email.text.toString())
        }

        btn_register.setOnClickListener {
            viewModel.registerUser(
                RegisterRequest(
                username.text.toString(),
                password.text.toString(),
                    nick.text.toString(),
                    phoneNumber.text.toString().toInt(),
                    email.text.toString()))
        }

    }

    private fun setupViewModel() {
        /*viewModel = ViewModelUtils.createViewModel(this)
        viewModel.registerResult.observe(this, Observer {
            if(it == null) {
                Toast.makeText(this, "Podany login jest już zajęty lub podano błędny email.", Toast.LENGTH_LONG).show()
            }
            else if(it.resultCode == RequestUtils.RESULTCODE_SUCCESS) {
                val intent = Intent()
                intent.putExtra(USER, USER(
                    username.text.toString(),
                    password.text.toString(),
                    nick.text.toString(),
                    phoneNumber.text.toString().toInt(),
                    email.text.toString()))
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        })

        viewModel.isValid.observe(this, Observer{isValid ->
                btn_register.isEnabled = isValid
        })*/
    }


}
