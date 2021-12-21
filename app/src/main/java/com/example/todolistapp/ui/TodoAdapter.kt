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
        val todoText = view.findViewById<TextView>(R.id.todoTv)
        val todoCheckBox = view.findViewById<CheckBox>(R.id.todoCb)
        val todoDelete = view.findViewById<ImageView>(R.id.todoDel)
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
        }




      /*  setOnClickListener {
            onItemClickListener?.let{ it(todoItem)}
        }*/


    }
    //val differ = AsyncListDiffer(this, TodoDiffCallback)


    /*fun submitListt(list: MutableList<TodoEntity>) {
        return differ.submitList(list)
    }*/


   class TodoDiffCallback: DiffUtil.ItemCallback<TodoEntity>() {


            override fun areItemsTheSame(oldItem: TodoEntity, newItem: TodoEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TodoEntity, newItem: TodoEntity): Boolean {
                return oldItem == newItem
            }
    }


    /*override fun submitList(list: MutableList<TodoEntity>?) {
        super.submitList(list?.let{ArrayList<TodoEntity>(it)})
    }*/

    /*private val DiffCallBack = object:  DiffUtil.ItemCallback<TodoEntity>() {


        override fun areItemsTheSame(oldItem: TodoEntity, newItem: TodoEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TodoEntity, newItem: TodoEntity): Boolean {
            return oldItem == newItem
        }
    }*/


   /* private var onItemClickListener: ((TodoEntity) -> Unit)? = null

    fun setOnClickListener(listener: (TodoEntity) -> Unit) {
        onItemClickListener = listener
    }*/




}