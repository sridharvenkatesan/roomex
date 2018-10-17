package com.irontec.roomexample.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.irontec.roomexample.database.entities.Moment

@Dao
interface MomentDao {
    @get:Query("SELECT * FROM moment")
    val all: List<Moment>

    @Query("SELECT * FROM moment WHERE uid IN (:momentId)")
    fun loadAllByIds(momentId: Array<Int>): List<Moment>

    @Insert
    fun insertAll(moments: List<Moment>)

    @Delete
    fun delete(client: Moment)
}