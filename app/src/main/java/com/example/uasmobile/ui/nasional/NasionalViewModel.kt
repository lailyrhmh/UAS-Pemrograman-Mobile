package com.example.uasmobile.ui.nasional

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uasmobile.network.Nasional
import com.example.uasmobile.network.NewsApi
import kotlinx.coroutines.launch

enum class NasionalApiStatus {LOADING, ERROR, DONE}

class NasionalViewModel : ViewModel() {

    private val _nasional = MutableLiveData<Nasional>()
    val nasional: LiveData<Nasional> = _nasional

    private val _nasionals = MutableLiveData<List<Nasional>>()
    val nasionals: LiveData<List<Nasional>> = _nasionals

    private val _status = MutableLiveData<NasionalApiStatus>()
    val status: LiveData<NasionalApiStatus> = _status

    fun listToString(list: List<String>): String {
        return list.joinToString("\n")
    }

    init {
        getNasionalList()
    }

    fun getNasionalList() {
        viewModelScope.launch {
            _status.value = NasionalApiStatus.LOADING
            try {
                _nasionals.value = NewsApi.retrofitService.getNasional().await().data
                _status.value = NasionalApiStatus.DONE
            } catch (e: Exception) {
                _nasionals.value = listOf()
                _status.value = NasionalApiStatus.ERROR
                Log.e("ErrorMsg", "${e.message}")
            }
        }
    }

    fun onNasionalClicked(nasional: Nasional) {
        _nasional.value = nasional
    }
}