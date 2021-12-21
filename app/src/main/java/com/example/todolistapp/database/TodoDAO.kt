package com.example.todolistapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDAO{

    @Update
    suspend fun updateTodo(todo: TodoEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTodo(todo: TodoEntity)

    @Delete
    suspend fun deleteTodo(todo: TodoEntity)

    @Query("SELECT * FROM todo_table")
    fun getAllTodos(): LiveData<List<TodoEntity>>

}
