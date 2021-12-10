package com.example.todolistapp.ui

import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.todolistapp.database.TodoDAO
import com.example.todolistapp.database.TodoDatabase
import com.example.todolistapp.database.TodoEntity

class Repository(private val db: TodoDatabase) {

    fun getTodos() = db.todoDBDao.getAllTodos()

    suspend fun insertTodo(todo: TodoEntity) = db.todoDBDao.insertTodo(todo)

    suspend fun deleteTodo(todo: TodoEntity) = db.todoDBDao.deleteTodo(todo)

    suspend fun updateTodo(todo: TodoEntity) = db.todoDBDao.updateTodo(todo)

}