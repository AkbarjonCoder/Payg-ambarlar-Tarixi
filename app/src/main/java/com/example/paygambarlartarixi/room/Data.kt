package com.example.paygambarlartarixi.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class Data(

    @ColumnInfo(name = "image") var image: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "number") var number : String,
    @ColumnInfo(name = "position") var position : Int,

    @PrimaryKey(autoGenerate = true) var id:Int=0
)
