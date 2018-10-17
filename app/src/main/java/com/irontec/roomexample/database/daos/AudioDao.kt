package com.irontec.roomexample.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.irontec.roomexample.database.entities.Audio

@Dao
interface AudioDao {
    @get:Query("SELECT * FROM audio")
    val all: List<Audio>

    @Query("SELECT * FROM audio WHERE uid IN (:audioId)")
    fun loadAllByIds(audioId: Array<Int>): List<Audio>

    @Insert
    fun insertAll(audios: List<Audio>)

    @Delete
    fun delete(client: Audio)
}