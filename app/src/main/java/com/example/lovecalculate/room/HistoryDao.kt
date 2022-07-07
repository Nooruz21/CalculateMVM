package com.example.lovecalculate.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculate.network.model.LoveModel
@Dao
interface HistoryDao {

    @Insert
    fun insert(model: LoveModel)


@Query("SELECT * FROM love_model ORDER BY firstName ASC")
    fun  getAll():LiveData<List<LoveModel>>


}