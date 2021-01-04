package com.example.androidx.ui.dsl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DslViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "DSL Fragment"
    }
    val text: LiveData<String> = _text
}