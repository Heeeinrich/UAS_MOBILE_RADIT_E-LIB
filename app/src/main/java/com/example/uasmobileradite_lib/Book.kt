package com.example.uasmobileradite_lib

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val imageUrl: String,
    val title: String,
    val author: String,
    val year: Int,
    val synopsis: String,
    val content: String,
    val isInLibrary: Boolean = false // Tambahkan properti ini
)
