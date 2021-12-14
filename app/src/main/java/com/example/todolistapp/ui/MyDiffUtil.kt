package com.example.todolistapp.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.todolistapp.database.TodoEntity

class MyDiffUtil(
    private val oldList: List<TodoEntity>,
    private val newList: List<TodoEntity>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
       return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return  when{
            oldList[oldItemPosition].id != newList[newItemPosition].id -> false
            oldList[oldItemPosition].title != newList[newItemPosition].title -> false
            oldList[oldItemPosition].isChecked != newList[newItemPosition].isChecked -> false
            else -> true
        }
    }


}