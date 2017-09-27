package com.example.devpartnerssoftware.instagram

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.util.Patterns
import co.blackfintech.authenticator.util.SessionStore
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        loginButton.onClick {
            val email = emailEdit.text.toString()
            val password = passwordEdit.text.toString()

            validate(email, password)
        }
    }

    private fun validate(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {

            alert("Enter Email & Password.", "Error") {
                okButton {
                    return@okButton
                }
            }.show()
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

            alert("Invalid Email", "Error") {
                okButton { return@okButton }
            }.show()
        } else if (email.equals("hannie@gmail.com") && password.equals("nakila")) {

            val store = SessionStore()
            store.saveEmail(email, this)
            startActivity<HomeActivity>()
            finish()
        } else if(!email.equals("hannie@gmail.com")){
            alert("Email not register", "Error") {
                okButton { return@okButton }
            }.show()
        }else{
            alert("Wrong password", "Error") {
                okButton { return@okButton }
            }.show()
        }
    }
}
