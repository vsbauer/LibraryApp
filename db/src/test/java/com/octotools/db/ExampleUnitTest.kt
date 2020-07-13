package com.octotools.db

import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val inMemorySqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).apply {
        Database.Schema.create(this)
    }

    private val queries = Database(inMemorySqlDriver).bookQueries

    @Test
    fun smokeTest() {
        val emptyItems = queries.selectAll().executeAsList()
        assertEquals(emptyItems.size, 0)

        queries.insert(
            author = "Pushkin",
            tittle = "Poems",
            img = null,
            link = ""
        )

        val items = queries.selectAll().executeAsList()
        assertEquals(items.size, 1)

        val item = queries.selectAll().executeAsOneOrNull()
        assertEquals(item?.author, "Pushkin")
        assertEquals(item?.img, null)
    }


}