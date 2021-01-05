package com.example.androidx.ui.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Share"
    }
    val text: LiveData<String> = _text

    private var count: Int? = null

    fun incrementCount() {
        count = count?.let { it + 1 } ?: 1
        _text.postValue("Share ${count ?: ""}")
    }

    fun decrementCount() {
        count = count?.let { it - 1 }
        if (count == 0) count = null
        _text.postValue("Share ${count ?: ""}")
    }

    fun resetCount() {
        count = null
        _text.postValue("Share")
    }
}