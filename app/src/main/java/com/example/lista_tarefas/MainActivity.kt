package com.example.lista_tarefas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_tarefas.databinding.ActivityMainBinding
import com.example.lista_tarefas.ui.TarefaAdapter
import com.example.lista_tarefas.ui.TarefaViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tarefaViewModel: TarefaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = TarefaAdapter(emptyList(),
            onItemClick = { tarefa ->
                // Abrir um diálogo para editar a tarefa, se quiser
            },
            onCheckedChange = { tarefa, isChecked ->
                val tarefaAtualizada = tarefa.copy(concluida = isChecked)
                tarefaViewModel.atualizar(tarefaAtualizada)
            }
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicializando o ViewModel
        tarefaViewModel = ViewModelProvider(this)[TarefaViewModel::class.java]

        // Observando mudanças na lista de tarefas e atualizando o adapter
        tarefaViewModel.todasTarefas.observe(this, Observer { tarefas ->
            tarefas?.let { adapter.updateTarefas(it) }
        })
    }
}

