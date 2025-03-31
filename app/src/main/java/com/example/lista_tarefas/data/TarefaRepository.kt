package com.example.lista_tarefas.data

import androidx.lifecycle.LiveData

class TarefaRepository(private val tarefaDao: TarefaDao){

    // Função para inserir uma tarefa
    suspend fun inserir(tarefa: Tarefa) {
        tarefaDao.inserir(tarefa)
    }

    // Função para atualizar uma tarefa
    suspend fun atualizar(tarefa: Tarefa) {
        tarefaDao.atualizar(tarefa)
    }

    // Função para deletar uma tarefa
    suspend fun deletar(tarefa: Tarefa) {
        tarefaDao.deletar(tarefa)
    }

    // LiveData para observar todas as tarefas
    val todasTarefas: LiveData<List<Tarefa>> = tarefaDao.todasTarefas()
}
