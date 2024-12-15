package com.example.uasmobileradite_lib

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.uasmobileradite_lib.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    suspend fun login(email: String, password: String): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun register(user: User)
}

