package com.oskarrek.it4animalcare.ui.login

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.UserModel
import com.oskarrek.it4animalcare.ui.login.register.RegisterActivity
import com.oskarrek.it4animalcare.ui.login.ui.login.LoggedInUserView
import com.oskarrek.it4animalcare.ui.login.ui.login.LoginViewModel
import com.oskarrek.it4animalcare.ui.login.ui.login.LoginViewModelFactory
import com.oskarrek.it4animalcare.ui.main.MainActivity.Companion.LOGIN
import com.oskarrek.it4animalcare.ui.main.MainActivity.Companion.PASSWORD
import com.oskarrek.it4animalcare.ui.main.MainActivity.Companion.REQUEST_SIGN_IN
import com.oskarrek.it4animalcare.ui.main.MainActivity.Companion.USER


class LoginActivity : AppCompatActivity() {

    companion object {
        val REQUEST_REGISTER = 102
    }

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)
        val register = findViewById<Button>(R.id.register)
        val loading = findViewById<ProgressBar>(R.id.loading)

        loginViewModel = ViewModelProviders.of(
            this,
            LoginViewModelFactory()
        )
            .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
            login.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }
        })

        loginViewModel.loginResponse.observe(this@LoginActivity, Observer {
            loading.visibility = View.GONE
            if (it == null) {
                Toast.makeText(this, "Błędny login lub hasło.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                intent.putExtra(USER, it)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }


        })

        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                username.text.toString(),
                password.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
                )
            }

            /*setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                            username.text.toString(),
                            password.text.toString()
                        )
                }
                false
            }*/

            login.setOnClickListener {
                loading.visibility = View.VISIBLE
                loginViewModel.login(username.text.toString(), password.text.toString())
            }

            register.setOnClickListener {
                startActivityForResult(
                    Intent(this@LoginActivity, RegisterActivity::class.java),
                    REQUEST_REGISTER
                )
            }
        }
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO : initiate successful logged in experience
        Toast.makeText(
            applicationContext,
            "$welcome $displayName",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_REGISTER) {
                val user =data?.getSerializableExtra(USER) as UserModel
                loginViewModel.login(user.login, user.password)
            }
        }
    }
}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}
