package com.example.paygambarlartarixi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.paygambarlartarixi.bottoms.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        val handler = Handler(mainLooper)
        handler.postDelayed( {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 2000)

    }
}