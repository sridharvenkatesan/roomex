package com.irontec.roomexample.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.irontec.roomexample.database.entities.Resident

@Dao
interface ResidentDao {
    @get:Query("SELECT * FROM resident")
    val all: List<Resident>

    @Query("SELECT * FROM resident WHERE uid IN (:residentId)")
    fun loadAllByIds(residentId: Array<Int>): List<Resident>

    @Insert
    fun insertAll(residents: List<Resident>)

    @Delete
    fun delete(client: Resident)
}