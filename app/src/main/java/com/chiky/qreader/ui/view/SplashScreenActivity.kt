package com.chiky.qreader.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import com.chiky.qreader.MainActivity
import com.chiky.qreader.R
import com.chiky.qreader.ui.viewModel.SplashScreenViewModel

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this)[SplashScreenViewModel::class.java]

        // Observe for task completion
        viewModel.performSplashScreenTask {
            // Navigate to the main activity or another screen
            //startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
            finish()
        }
    }
}