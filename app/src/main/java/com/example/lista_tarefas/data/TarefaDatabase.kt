package com.example.lista_tarefas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tarefa::class], version = 1, exportSchema = false)
    abstract class TarefaDatabase : RoomDatabase() {
        abstract fun tarefaDao(): TarefaDao

        companion object {
            @Volatile
            private var INSTANCE: TarefaDatabase? = null

            fun getDatabase(context: Context): TarefaDatabase {
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TarefaDatabase::class.java,
                        "tarefa_database"
                    ).build()
                    INSTANCE = instance
                    instance
                }
            }
        }
    }