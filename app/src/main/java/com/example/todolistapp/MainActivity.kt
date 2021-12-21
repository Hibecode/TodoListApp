package com.example.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

    lateinit var viewModel: TodoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val database = TodoDatabase.getDatabase(this)
        val repository = Repository(database)
        val factory = TodoViewModelFactory(repository)



        viewModel = ViewModelProvider(this, factory).get(TodoViewModel::class.java)

        val myAdapter = TodoAdapter(viewModel)
        todorv.layoutManager = LinearLayoutManager(this)
        todorv.adapter = myAdapter



       /* viewModel.getAllTodos.observe(this, Observer{
                it?.let{
                    val newList: List<TodoEntity>
                    myAdapter.submitList(it.toMutableList())
                }
            })*/



        addbutton.setOnClickListener{
            val newText = addeT.text.toString()
            val check = false
            val newTodo = TodoEntity(newText, check)
            viewModel.insertTodo(newTodo)

            /*viewModel.getAllTodos().observe(this, Observer{
                it?.let{
                    val newList: List<TodoEntity>
                    myAdapter.submitList(it.toMutableList())
                }
            })*/


            /*viewModel.getAllTodos.observe(this, Observer{
                myAdapter.submitList(it?.toMutableList())
            })*/

            /*Toast.makeText(this, "PLEASE WORK!!", Toast.LENGTH_SHORT).show()
            listee.add(newTodo)
            myAdapter.submitList(listee)

            myAdapter.notifyItemInserted(myAdapter.currentList.size.plus(1))*/
            /*myAdapter.currentList.add(TodoEntity("No5", false))
            val newLip = myAdapter.currentList
            myAdapter.submitList(newLip)*/

        }
        viewModel.getAllTodos.observe(this, Observer{
            myAdapter.submitList(it?.toMutableList())
        })













    }



}