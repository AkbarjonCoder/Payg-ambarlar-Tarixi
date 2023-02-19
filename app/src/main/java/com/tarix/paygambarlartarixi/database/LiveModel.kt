package com.tarix.paygambarlartarixi.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LiveModel {

    fun sending(){
        var send = MutableLiveData<Int>()

        var observer : LiveData<Int> = send
    }

}