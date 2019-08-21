package com.example.androidarch.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {

    fun onStarted()
    fun onSucess(loginResponse: LiveData<String>)
    fun onFailure(message: String)
}