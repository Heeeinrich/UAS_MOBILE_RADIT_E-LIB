package com.example.uasmobileradite_lib

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.uasmobileradite_lib.Book

@Dao
interface BookDao {

    // Mendapatkan semua buku dari tabel "books"
    @Query("SELECT * FROM books")
    fun getAllBooks(): LiveData<List<Book>>

    // Mendapatkan semua buku yang ditandai sebagai bagian dari library (isInLibrary = 1)
    @Query("SELECT * FROM books WHERE isInLibrary = 1")
    fun getLibraryBooks(): LiveData<List<Book>>

    // Menambahkan atau memperbarui data buku di tabel
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book)

    // Menghapus buku dari tabel
    @Delete
    suspend fun delete(book: Book)
}
