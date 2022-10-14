package com.example.homeproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _str = MutableLiveData<String>()
    val str : LiveData<String> = _str

    fun changeText(){
        _str.value = "I love Ukraine"
    }
}