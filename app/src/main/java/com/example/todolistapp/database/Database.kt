package com.example.todolistapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/*
@Database(entities = [TodoEntity::class], version = 1 ,exportSchema = false)
abstract class TodoDatabase(): RoomDatabase() {

    abstract val todoDBDao : TodoDAO

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
*/



@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {

    abstract  fun todoDBDao(): TodoDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: TodoDatabase? = null

        private val LOCK = Any()



        /*operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: createDatabase(context).also { INSTANCE = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            Todo_Database::class.java, "SomeShoppingDB.db").build()*/




        fun getDatabase(context: Context): TodoDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "TodoDB.db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }


}