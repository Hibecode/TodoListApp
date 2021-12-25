package com.example.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.database.TodoDatabase
import com.example.todolistapp.database.TodoEntity
import com.example.todolistapp.database.Repository
import com.example.todolistapp.ui.TodoAdapter
import com.example.todolistapp.ui.TodoViewModel
import com.example.todolistapp.ui.TodoViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lateinit var viewModel: TodoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = TodoDatabase.getInstance(this)
        val repository = Repository(database)
        val factory = TodoViewModelFactory(repository)

        var viewModel = ViewModelProvider(this, factory).get(TodoViewModel::class.java)

        val myAdapter = TodoAdapter(viewModel)
        todorv.layoutManager = LinearLayoutManager(this)
        todorv.adapter = myAdapter

        addbutton.setOnClickListener{
            val newText = addeT.text.toString()
            val newTodo = TodoEntity(newText)
            viewModel.insertTodo(newTodo)
            addeT.text = null
        }

        viewModel.getAllTodos.observe(this, Observer{
            myAdapter.submitList(it?.toMutableList())
        })


    }



}