package com.example.todolistapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


//@Suppress("UNCHECKED CAST")
class TodoViewModelFactory(val repository: Repository): ViewModelProvider.NewInstanceFactory() {

    /*override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TodoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }*/


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TodoViewModel(repository) as T
    }
}