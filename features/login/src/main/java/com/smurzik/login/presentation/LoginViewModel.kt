package com.smurzik.login.presentation

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _validInputsLiveData = MutableLiveData(false)
    val validInputsLiveData: LiveData<Boolean> = _validInputsLiveData

    fun checkValidInputs(email: String, password: String) {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.isNotEmpty())
            _validInputsLiveData.value = true
    }
}