package com.example.lista_tarefas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tarefa_table")
data class Tarefa (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val descricao: String,
    var concluida: Boolean
)



