package com.example.databindingexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _name: MutableLiveData<String> = MutableLiveData()

    val name: LiveData<String> get() =  _name

    init {
        _name.value = "Something"
    }

    fun changeName(text:String){
        _name.value=text

    }

}