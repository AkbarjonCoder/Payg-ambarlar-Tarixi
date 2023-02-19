package com.tarix.paygambarlartarixi.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: Data)

    @Query("Select * from data")
    fun getData() : LiveData<List<Data>>

    @Query("DELETE FROM data where id=:id")
    suspend fun delete(id : Int)

}