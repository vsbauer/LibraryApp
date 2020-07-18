package com.github.vsbauer.library.db

import android.content.Context
import com.github.vsbauer.core.models.Book
import com.squareup.sqldelight.android.AndroidSqliteDriver
import javax.inject.Inject

class DatabaseRepository @Inject constructor(appContext: Context) {
    private val androidSqlDriver = AndroidSqliteDriver(
        schema = Database.Schema,
        context = appContext,
        name = "books.db"
    )

    private val queries = Database(androidSqlDriver).bookQueries

    fun getSavedBooks(): List<Book> = queries.selectAll().executeAsList().map {
        Book(
            author = it.author ?: "",
            tittle = it.tittle ?: "",
            img = it.img ?: "",
            link = it.link ?: ""
        )
    }

    fun saveBook(book: Book) = queries.insert(book.author, book.tittle, book.img, book.link)

    fun removeBook(book: Book) {
        queries.delete(listOf(book.author), listOf(book.tittle))
    }
}