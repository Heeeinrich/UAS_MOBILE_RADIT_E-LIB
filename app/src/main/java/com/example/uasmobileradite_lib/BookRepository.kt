package com.example.uasmobileradite_lib

import androidx.lifecycle.LiveData
import com.example.uasmobileradite_lib.BookDao
import com.example.uasmobileradite_lib.Book

class BookRepository(private val bookDao: BookDao) {

    fun getAllBooks(): LiveData<List<Book>> = bookDao.getAllBooks()

    fun getLibraryBooks(): LiveData<List<Book>> = bookDao.getLibraryBooks()

    suspend fun insertBook(book: Book) {
        bookDao.insert(book)
    }

    suspend fun deleteBook(book: Book) {
        bookDao.delete(book)
    }
}
