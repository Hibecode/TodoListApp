package com.example.todolistapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


@Suppress("UNCHECKED CAST")
class TodoViewModelFactory(val repository: Repository): ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TodoViewModel(repository) as T
    }
}