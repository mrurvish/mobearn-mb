package com.mobearn.ad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.view.View
import android.view.WindowManager

@Suppress("DEPRECATION")
class SplaceScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace_screen)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        /*window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )*/
        //new methode

        window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000) // 3000 is the delayed time in milliseconds.
    }
}

