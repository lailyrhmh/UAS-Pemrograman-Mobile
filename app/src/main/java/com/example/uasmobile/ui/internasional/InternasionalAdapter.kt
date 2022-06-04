package com.example.uasmobile.ui.internasional

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uasmobile.network.Internasional


class InternasionalAdapter (private val clickListener: InternasionalListener) :
    ListAdapter<Internasional, InternasionalAdapter.InternasionalViewHolder>(DiffCallback)
{
    class InternasionalViewHolder(
        var binding: InternasionalRowBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: InternasionalListener, internasional: Internasional) {
            binding.internasional = internasional
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Internasional>() {
        override fun areItemsTheSame(oldItem: Internasional, newItem: Internasional): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Internasional, newItem: Internasional): Boolean {
            return oldItem.link == newItem.link && oldItem.contentSnippet == newItem.contentSnippet
                    && oldItem.isoDate == newItem.isoDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InternasionalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return InternasionalViewHolder(
            InternasionalRowBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: InternasionalViewHolder, position: Int) {
        val internasional = getItem(position)
        holder.bind(clickListener, internasional)
    }

}
class InternasionalListener(val clickListener: (internasional: Internasional) -> Unit) {
    fun onClick(internasional: Internasional) = clickListener(internasional)
}