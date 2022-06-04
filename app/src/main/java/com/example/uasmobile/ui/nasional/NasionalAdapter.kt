package com.example.uasmobile.ui.nasional

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uasmobile.databinding.NasionalItemBinding
import com.example.uasmobile.network.Nasional

class NasionalAdapter(private val clickListener: NasionalListener) :
    ListAdapter<Nasional, NasionalAdapter.NasionalViewHolder>(DiffCallback)
{
    class NasionalViewHolder(
        var binding: NasionalItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: NasionalListener, nasional: Nasional) {
            binding.nasional = nasional
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Nasional>() {
        override fun areItemsTheSame(oldItem: Nasional, newItem: Nasional): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Nasional, newItem: Nasional): Boolean {
            return oldItem.link == newItem.link && oldItem.contentSnippet == newItem.contentSnippet && oldItem.isoDate == newItem.isoDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasionalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NasionalViewHolder(
            NasionalItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: NasionalViewHolder, position: Int) {
        val nasional = getItem(position)
        holder.bind(clickListener, nasional)
    }

}
class NasionalListener(val clickListener: (nasional: Nasional) -> Unit) {
    fun onClick(nasional: Nasional) = clickListener(nasional)
}

