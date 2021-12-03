package com.example.todolistapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="TodoTable")
data class TodoEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1,
    @ColumnInfo(name="title")
    var title: String = "Work",

    @ColumnInfo(name="isCompleted")
    var isCompleted: Boolean = false

)