package com.example.todolistapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.R
import com.example.todolistapp.database.TodoEntity

class TodoAdapter(private var viewModel: TodoViewModel): ListAdapter<TodoEntity, TodoAdapter.TodoViewHolder>(TodoAdapter.TodoDiffCallback()) {


    inner class TodoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val todoText: TextView = view.findViewById(R.id.todoTv)
        val todoCheckBox: CheckBox = view.findViewById(R.id.todoCb)
        val todoDelete: ImageView = view.findViewById(R.id.todoDel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item_layout, parent, false)

        return TodoViewHolder(view)
    }


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        var todoItem = currentList[position]

        holder.apply{
            todoText.text = todoItem.title
            todoCheckBox.isChecked = todoItem.isChecked == true
            todoDelete.setOnClickListener{
                viewModel.deleteTodo(todoItem)
            }
            todoCheckBox.setOnClickListener{
                todoItem.isChecked = !todoItem.isChecked
                viewModel.updateTodo(todoItem)
            }
        }


    }

   class TodoDiffCallback: DiffUtil.ItemCallback<TodoEntity>() {

            override fun areItemsTheSame(oldItem: TodoEntity, newItem: TodoEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TodoEntity, newItem: TodoEntity): Boolean {
                return oldItem == newItem
            }
    }
}