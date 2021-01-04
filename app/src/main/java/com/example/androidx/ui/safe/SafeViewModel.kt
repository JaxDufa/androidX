package com.example.androidx.ui.safe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SafeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Safe Fragment"
    }
    val text: LiveData<String> = _text
}