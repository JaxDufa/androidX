package com.example.androidx.ui.more

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoreViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "More Fragment"
    }
    val text: LiveData<String> = _text
}