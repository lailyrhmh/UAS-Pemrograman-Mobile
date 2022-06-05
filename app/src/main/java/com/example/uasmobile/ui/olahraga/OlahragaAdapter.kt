package com.example.uasmobile.ui.olahraga

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uasmobile.network.Olahraga

class OlahragaAdapter(private val clickListener: OlahragaListener) :
    ListAdapter<Olahraga, OlahragaAdapter.OlahragaViewHolder>(DiffCallback)
{
    class OlahragaViewHolder(
        var binding: OlahragaItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: OlahragaListener, olahraga: Olahraga) {
            binding.olahraga = olahraga
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Olahraga>() {
        override fun areItemsTheSame(oldItem: Olahraga, newItem: Olahraga): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Olahraga, newItem: Olahraga): Boolean {
            return oldItem.link == newItem.link && oldItem.contentSnippet == newItem.contentSnippet && oldItem.isoDate == newItem.isoDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OlahragaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return OlahragaViewHolder(
            OlahragaItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: OlahragaViewHolder, position: Int) {
        val olahraga = getItem(position)
        holder.bind(clickListener, olahraga)
    }

}
class OlahragaListener(val clickListener: (olahraga: Olahraga) -> Unit) {
    fun onClick(olahraga: Olahraga) = clickListener(olahraga)
}