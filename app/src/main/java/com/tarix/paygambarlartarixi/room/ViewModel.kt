package com.tarix.paygambarlartarixi.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel(val dao: Dao):ViewModel() {

    val getData: LiveData<List<Data>> = dao.getData()

    fun insertData(data : Data)= viewModelScope.launch {
        dao.insertData(data)
    }

    fun delete(id : Int) = viewModelScope.launch {
        dao.delete(id)
    }

}