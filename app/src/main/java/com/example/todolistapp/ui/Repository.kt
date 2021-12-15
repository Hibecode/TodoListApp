package com.example.todolistapp.ui

import androidx.annotation.WorkerThread
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.todolistapp.database.TodoDAO
import com.example.todolistapp.database.TodoDatabase
import com.example.todolistapp.database.TodoEntity

class Repository(private val db: TodoDatabase) {

    fun getTodos() = db.todoDBDao().getAllTodos()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertTodo(todo: TodoEntity) = db.todoDBDao().insertTodo(todo)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteTodo(todo: TodoEntity) = db.todoDBDao().deleteTodo(todo)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateTodo(todo: TodoEntity) = db.todoDBDao().updateTodo(todo)

}