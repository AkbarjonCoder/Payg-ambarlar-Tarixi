package com.example.paygambarlartarixi.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.paygambarlartarixi.room.Data

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: Data)

    @Query("Select * from data")
    fun getData() : LiveData<List<Data>>

    @Query("DELETE FROM data where id=:id")
    suspend fun delete(id : Int)

}