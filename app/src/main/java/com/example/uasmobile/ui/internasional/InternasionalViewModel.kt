package com.example.uasmobile.ui.internasional

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uasmobile.network.Internasional
import com.example.uasmobile.network.NewsApi
import kotlinx.coroutines.launch

enum class InternasionalApiStatus { LOADING, ERROR, DONE }

class InternasionalViewModel : ViewModel() {
    private val _status = MutableLiveData<InternasionalApiStatus>()
    val status: LiveData<InternasionalApiStatus> = _status

    private val _internasionals = MutableLiveData<List<Internasional>>()
    val internasionals: LiveData<List<Internasional>> = _internasionals

    private val _internasional = MutableLiveData<Internasional>()
    val internasional: LiveData<Internasional> = _internasional

    fun listToString(list: List<String>): String {
        return list.joinToString("\n")
    }

    fun getInternasionalList() {
        viewModelScope.launch {
            _status.value = InternasionalApiStatus.LOADING
                try {
                    _internasionals.value = NewsApi.retrofitService.getInternasional().await().data
                    _status.value = InternasionalApiStatus.DONE
                } catch (e: Exception) {
                    _internasionals.value = listOf()
                    _status.value = InternasionalApiStatus.ERROR
                    Log.e("ErrorMsg", "${e.message}")
                }
            }
        }

        fun onInternasionalClicked(internasional: Internasional) {
            _internasional.value = internasional
        }
    }