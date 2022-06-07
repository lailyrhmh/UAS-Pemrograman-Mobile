package com.example.uasmobile

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uasmobile.network.Internasional
import com.example.uasmobile.network.Nasional
import com.example.uasmobile.ui.internasional.InternasionalAdapter
import com.example.uasmobile.ui.internasional.InternasionalApiStatus
import com.example.uasmobile.ui.nasional.NasionalAdapter
import com.example.uasmobile.ui.nasional.NasionalApiStatus

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Nasional>?) {
    val adapter = recyclerView.adapter as NasionalAdapter
    adapter.submitList(data)
}

@JvmName("bindRecyclerView1")
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Internasional>?) {
    val adapter = recyclerView.adapter as InternasionalAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: NasionalApiStatus?) {
    when(status) {
        NasionalApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        NasionalApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        NasionalApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: InternasionalApiStatus?) {
    when(status) {
        InternasionalApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        InternasionalApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        InternasionalApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}