package com.ya.iticourse.ui.login
import android.annotation.SuppressLint


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.ya.iticourse.ui.second.SecondActivity

import com.ya.iticourse.databinding.ActivityMainBinding
import com.ya.iticourse.core.data_source.remote.ApiInterface


class LoginActivity :AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var retrofit : ApiInterface
    lateinit var sharedPref :SharedPreferences
    lateinit var viewModel: LoginViewModel


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = LoginViewModel()

        sharedPref = applicationContext.getSharedPreferences("UserPref", MODE_PRIVATE)
        viewModel.loginData.observe(this){
            Toast.makeText(this,"welcome ${it.body()?.firstName}",Toast.LENGTH_LONG).show()
        }




                binding.loginButton.setOnClickListener {
                    viewModel.startLogin(binding.usernameEt.text.toString(),binding.passwordEt.text.toString())


                    }
                    val intent = Intent(this, SecondActivity::class.java)
                    startActivity(intent)

                }



            }






