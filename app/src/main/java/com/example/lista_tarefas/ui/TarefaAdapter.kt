package com.example.lista_tarefas.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_tarefas.R
import com.example.lista_tarefas.data.Tarefa

class TarefaAdapter(   private var tarefas: List<Tarefa>,
                       private val onItemClick: (Tarefa) -> Unit
) : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    class TarefaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome = itemView.findViewById<TextView>(R.id.nome_tarefa)
        val descricao = itemView.findViewById<TextView>(R.id.descricao_tarefa)
        val checkConcluida = itemView.findViewById<CheckBox>(R.id.checkbox_concluida)
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
            tarefaAtual.concluida = isChecked
            // Atualize a tarefa no banco de dados ao marcar/desmarcar
        }
    }

    override fun getItemCount() = tarefas.size

    // Adicione este método para atualizar a lista de tarefas no adapter
    fun updateTarefas(novasTarefas: List<Tarefa>) {
        tarefas = novasTarefas
        notifyDataSetChanged()
    }
}