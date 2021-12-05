package com.example.todolistapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [TodoEntity::class], version = 1 ,exportSchema = false)
abstract class TodoDatabase(): RoomDatabase() {

    abstract val TodoDBDao : TodoDAO

    companion object {

        @Volatile
        private var INSTANCE: TodoDatabase? = null


        fun getInstance(context: Context): TodoDatabase {

            var instance = INSTANCE

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        TodoDatabase::class.java,
                        "Todo_Database")
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
                }
            }

        }

    }