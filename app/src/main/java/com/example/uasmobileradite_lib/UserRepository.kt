package com.example.uasmobileradite_lib

import com.example.uasmobileradite_lib.UserDao
import com.example.uasmobileradite_lib.User

class UserRepository(private val userDao: UserDao) {

    suspend fun login(email: String, password: String): User? {
        return userDao.login(email, password)
    }

    suspend fun register(user: User) {
        userDao.register(user)
    }
}
