package com.example.todolistapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistapp.database.TodoEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.Entity

class TodoViewModel(private val repo: Repository): ViewModel() {

    fun getAllTodos() = repo.getTodos()


    fun deleteTodo(todo: TodoEntity) = viewModelScope.launch(Dispatchers.Main){
        repo.deleteTodo(todo)
    }

    fun insertTodo(todo: TodoEntity) = viewModelScope.launch(Dispatchers.Main) {
        repo.insertTodo(todo)
    }

    fun updateTodo(todo: TodoEntity) = viewModelScope.launch(Dispatchers.Main) {
        repo.updateTodo(todo)
    }




}