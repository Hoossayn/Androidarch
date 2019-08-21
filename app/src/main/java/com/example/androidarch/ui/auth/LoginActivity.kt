package com.example.androidarch.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidarch.R
import com.example.androidarch.databinding.ActivityLoginBinding
import com.example.androidarch.util.hide
import com.example.androidarch.util.show
import com.example.androidarch.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding : ActivityLoginBinding  = DataBindingUtil.setContentView(this, R.layout.activity_login)

        var viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        progress_Bar.show()
    }

    override fun onSucess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            progress_Bar.hide()
            toast(it)
        })
    }

    override fun onFailure(message: String) {
    progress_Bar.hide()
    }

}
