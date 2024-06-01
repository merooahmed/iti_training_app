package com.ya.iticourse.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.ya.iticourse.R
import com.ya.iticourse.ui.login.LoginActivity


class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val splash:Long = 2000
        Handler().postDelayed(
            {val intent= Intent(this, LoginActivity::class.java)
                startActivity(intent)
                 finish()
            },splash)

    }
}