package com.example.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.database.TodoDatabase
import com.example.todolistapp.database.TodoEntity
import com.example.todolistapp.ui.Repository
import com.example.todolistapp.ui.TodoAdapter
import com.example.todolistapp.ui.TodoViewModel
import com.example.todolistapp.ui.TodoViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.util.EnumSet.of

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val database = TodoDatabase.getInstance(this)
        val repository = Repository(database)
        val factory = TodoViewModelFactory(repository)



        val viewModel = ViewModelProvider(this, factory).get(TodoViewModel::class.java)

        val myAdapter = TodoAdapter()
        todorv.layoutManager = LinearLayoutManager(this)
        todorv.adapter = myAdapter

        val listee = listOf(TodoEntity("No1", false))

        addbutton.setOnClickListener{
            val newText = addeT.text.toString()
            val check = false
            val newTodo = TodoEntity("rjgndrgn", check)
            viewModel.insertTodo(newTodo)
            val liste = listOf(newTodo)
            //myAdapter.differ.submitList(liste)
            /*viewModel.getAllTodos().observe(this, Observer{ it?.let{

                myAdapter.submitList(it) }
            })*/

        }





    }
}