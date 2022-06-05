package com.example.uasmobile.ui.olahraga

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uasmobile.network.Nasional
import com.example.uasmobile.network.NewsApi
import com.example.uasmobile.network.Olahraga
import kotlinx.coroutines.launch

enum class OlahragaApiStatus {LOADING, ERROR, DONE}

class OlahragaViewModel : ViewModel() {

    private val _olahraga = MutableLiveData<Olahraga>()
    val olahraga: LiveData<Olahraga> = _olahraga

    private val _olahragas = MutableLiveData<List<Olahraga>>()
    val olahragas: LiveData<List<Olahraga>> = _olahragas

    private val _status = MutableLiveData<OlahragaApiStatus>()
    val status: LiveData<OlahragaApiStatus> = _status

    fun listToString(list: List<String>): String {
        return list.joinToString("\n")
    }

    init {
        getOlahragaList()
    }

    fun getOlahragaList() {
        viewModelScope.launch {
            _status.value = OlahragaApiStatus.LOADING
            try {
                _olahragas.value = NewsApi.retrofitService.getOlahraga().await().data
                _status.value = OlahragaApiStatus.DONE
            } catch (e: Exception) {
                _olahragas.value = listOf()
                _status.value = OlahragaApiStatus.ERROR
                Log.e("ErrorMsg", "${e.message}")
            }
        }
    }

    fun onOlahragaClicked(olahraga: Olahraga) {
        _olahraga.value = olahraga
    }
}