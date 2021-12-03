package com.example.todolistapp.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


class TodoDAO() {

    @Update
    fun updateTodo(todo: TodoEntity) {}


    @Insert
    fun InsertTodo(todo: TodoEntity) {}




    @Delete
    fun deleteTodo() {}

    @Query("SELECT * FROM todo_table")
    fun getAllTodos() {}

}
