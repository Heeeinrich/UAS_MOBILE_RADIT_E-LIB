package com.example.uasmobileradite_lib

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uasmobileradite_lib.BookDatabase
import com.example.uasmobileradite_lib.Book
import com.example.uasmobileradite_lib.BookRepository
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BookRepository
    val allBooks: LiveData<List<Book>>
    val libraryBooks: LiveData<List<Book>>

    init {
        val bookDao = BookDatabase.getDatabase(application).bookDao()
        repository = BookRepository(bookDao)
        allBooks = repository.getAllBooks()
        libraryBooks = repository.getLibraryBooks()
    }

    fun insertBook(book: Book) = viewModelScope.launch {
        repository.insertBook(book)
    }

    fun deleteBook(book: Book) = viewModelScope.launch {
        repository.deleteBook(book)
    }
}
