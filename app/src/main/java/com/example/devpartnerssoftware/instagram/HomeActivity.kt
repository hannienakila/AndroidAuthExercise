package com.example.devpartnerssoftware.instagram

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.blackfintech.authenticator.util.SessionStore
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        logoutImageButton.onClick {
            logoutFacebook()
        }
    }

    private fun logoutFacebook() {
        SessionStore().clearEmail(this)
        finish()
        startActivity<SplashActivity>()
    }
}
