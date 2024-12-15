package com.example.uasmobileradite_lib

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface BookApiService {
    @GET("library/books")
    suspend fun getAllBooks(): List<Book>

    @POST("library/books")
    suspend fun addBook(@Body book: Book): Response<Book>  // Response wrapping Book object

    @PUT("library/books/{id}")
    suspend fun updateBook(@Path("id") id: Int, @Body book: Book): Response<Book>  // Response wrapping Book object

    @DELETE("library/books/{id}")
    suspend fun deleteBook(@Path("id") id: Int): Response<Void>  // Response with no body
}
