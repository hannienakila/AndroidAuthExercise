package com.example.devpartnerssoftware.instagram

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import co.blackfintech.authenticator.util.SessionStore
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler().postDelayed({

            val email = SessionStore().restoreEmail(this)
            if(email.isEmpty()){
                startActivity<MainActivity>()
            }else{
                startActivity<HomeActivity>()
            }
            finish()
        },3000)


    }
}
