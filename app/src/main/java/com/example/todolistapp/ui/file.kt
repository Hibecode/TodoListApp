package com.example.todolistapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.R
import com.example.todolistapp.database.TodoEntity

class TodoAdapter(private var Todos: MutableList<TodoEntity>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {


    inner class TodoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val todoText = view.findViewById<TextView>(R.id.todoTv)
        val todoCheckBox = view.findViewById<CheckBox>(R.id.todoCb)
        val todoDelete = view.findViewById<ImageView>(R.id.todoDel)
    }

    override fun getItemCount() = Todos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item_layout, parent, false)

        return TodoViewHolder(view)
    }


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        var todoItem = Todos[position]

        holder.apply{
            todoText.text = todoItem.title
            todoCheckBox.isChecked = todoItem.isChecked
        }
    }


    class TodoDiffCallback(): DiffUtil.ItemCallback<TodoEntity>() {
        override fun areItemsTheSame(oldItem: TodoEntity, newItem: TodoEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TodoEntity, newItem: TodoEntity): Boolean {
            return oldItem == newItem
        }

    }




}