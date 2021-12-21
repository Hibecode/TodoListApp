package com.example.todolistapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="todo_table")
data class TodoEntity (
    @ColumnInfo(name="title")
    var title: String,

    @ColumnInfo(name="is_Completed")
    var isChecked: Boolean = false

){@PrimaryKey(autoGenerate = true)
var id: Int = 0}
