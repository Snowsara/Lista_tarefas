package com.example.lista_tarefas.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.lista_tarefas.data.Tarefa
import com.example.lista_tarefas.data.TarefaDatabase
import com.example.lista_tarefas.data.TarefaRepository
import kotlinx.coroutines.launch

class TarefaViewModel (application: Application) : AndroidViewModel(application) {
    private val repository: TarefaRepository
    val todasTarefas: LiveData<List<Tarefa>>

    init {
        val tarefaDao = TarefaDatabase.TarefaDatabase.getDatabase(application).tarefaDao()
        repository = TarefaRepository(tarefaDao)
        todasTarefas = repository.todasTarefas
    }

    fun inserir(tarefa: Tarefa) = viewModelScope.launch {
        repository.inserir(tarefa)
    }

    fun atualizar(tarefa: Tarefa) = viewModelScope.launch {
        repository.atualizar(tarefa)
    }

    fun deletar(tarefa: Tarefa) = viewModelScope.launch {
        repository.deletar(tarefa)
    }
}

