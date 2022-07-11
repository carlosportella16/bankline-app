package com.dio.bankline.ui.statement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dio.bankline.R
import com.dio.bankline.databinding.BankStatementItemBinding
import com.dio.bankline.domain.Movimentacao
import com.dio.bankline.domain.TipoMovimentacao

/**
 * Reference: https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=pt-br#kotlin
 */
class BankStatmentAdapter(private val dataSet: List<Movimentacao>) : RecyclerView.Adapter<BankStatmentAdapter.ViewHolder>() {

    class ViewHolder(private val binding: BankStatementItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movimentacao) = with(binding) {
            tvDescription.text = item.descricao
            tvValue.text = item.valor.toString()
            tvDatetime.text = item.dataHora
            val typeIcon = if (TipoMovimentacao.RECEITA == item.tipo) R.drawable.ic_money_in  else R.drawable.ic_money_out
            ivIcon.setImageResource(typeIcon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BankStatementItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]
        viewHolder.bind(item)
    }

    override fun getItemCount() = dataSet.size
}