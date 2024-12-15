package com.example.uasmobileradite_lib.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.uasmobileradite_lib.AppDatabase
import com.example.uasmobileradite_lib.User
import com.example.uasmobileradite_lib.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository

    init {
        val userDao = AppDatabase.getInstance(application).userDao()
        repository = UserRepository(userDao)
    }

    fun login(email: String, password: String, onSuccess: (User?) -> Unit) {
        viewModelScope.launch {
            val user = repository.login(email, password)
            onSuccess(user)
        }
    }

    fun register(user: User, onSuccess: () -> Unit) {
        viewModelScope.launch {
            repository.register(user)
            onSuccess()
        }
    }
}
