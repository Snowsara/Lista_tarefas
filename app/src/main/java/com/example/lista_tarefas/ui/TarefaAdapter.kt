package com.example.lista_tarefas.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_tarefas.R
import com.example.lista_tarefas.data.Tarefa

class TarefaAdapter(
    private var tarefas: List<Tarefa>,
    private val onItemClick: (Tarefa) -> Unit,
    private val onCheckedChange: (Tarefa, Boolean) -> Unit // Adicionado
) : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    class TarefaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome: TextView = itemView.findViewById(R.id.nome_tarefa)
        val descricao: TextView = itemView.findViewById(R.id.descricao_tarefa)
        val checkConcluida: CheckBox = itemView.findViewById(R.id.checkbox_concluida)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarefa, parent, false)
        return TarefaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefaAtual = tarefas[position]
        holder.nome.text = tarefaAtual.nome
        holder.descricao.text = tarefaAtual.descricao
        holder.checkConcluida.isChecked = tarefaAtual.concluida

        holder.itemView.setOnClickListener {
            onItemClick(tarefaAtual)
        }

        holder.checkConcluida.setOnCheckedChangeListener { _, isChecked ->
            onCheckedChange(tarefaAtual, isChecked)
        }
    }

    override fun getItemCount() = tarefas.size

    fun updateTarefas(novasTarefas: List<Tarefa>) {
        tarefas = novasTarefas
        notifyDataSetChanged()
    }
}