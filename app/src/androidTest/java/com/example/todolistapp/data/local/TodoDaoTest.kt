package com.example.todolistapp.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.todolistapp.database.TodoDAO
import com.example.todolistapp.database.TodoDatabase
import com.example.todolistapp.database.TodoEntity
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
@SmallTest
class TodoDaoTest {

    private lateinit var todoDao: TodoDAO
    private lateinit var db: TodoDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, TodoDatabase::class.java
        ).build()
        todoDao = db.todoDBDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val todoItem = TodoEntity("Pls work!", false)
        todoDao.insertTodo(todoItem)


    }
}