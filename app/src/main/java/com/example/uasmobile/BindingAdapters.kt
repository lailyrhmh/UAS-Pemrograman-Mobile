package com.example.uasmobile

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uasmobile.network.Nasional
import com.example.uasmobile.ui.nasional.NasionalAdapter
import com.example.uasmobile.ui.nasional.NasionalApiStatus

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Nasional>?) {
    val adapter = recyclerView.adapter as NasionalAdapter
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