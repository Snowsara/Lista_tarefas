package com.example.lista_tarefas.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TarefaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun inserir(tarefa: Tarefa)

    @Update
    suspend fun atualizar(tarefa: Tarefa)

    @Delete
    suspend fun deletar(tarefa: Tarefa)

    @Query("SELECT * FROM tarefa_table ORDER BY id ASC")
    fun todasTarefas(): LiveData<List<Tarefa>>
}

