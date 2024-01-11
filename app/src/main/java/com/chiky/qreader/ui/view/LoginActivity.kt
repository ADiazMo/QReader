package com.chiky.qreader.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.chiky.qreader.MainActivity
import com.chiky.qreader.R
import com.chiky.qreader.data.model.Login
import com.chiky.qreader.databinding.ActivityLoginBinding
import com.chiky.qreader.ui.viewModel.LoginViewModel

//import com.chiky.qreader.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        // Login button
        binding.login.setOnClickListener{
            val login = Login(binding.username.text.toString(),binding.password.text.toString())
            var resultLogin = viewModel.LoginCandidate(login)

            if (resultLogin){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        // Register button
        binding.register.setOnClickListener{
            //intent to register activity
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }


    }
}