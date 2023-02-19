package com.tarix.paygambarlartarixi.database

import androidx.annotation.Keep

@Keep
data class SaveData(
    var image : Int,
    var title: String,
    var number: String,
    var position : Int
)