package com.irontec.roomexample.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.irontec.roomexample.database.entities.Theme

@Dao
interface ThemeDao {
    @get:Query("SELECT * FROM theme")
    val all: List<Theme>

    @Query("SELECT * FROM theme WHERE uid IN (:recipientId)")
    fun loadAllByIds(recipientId: Array<Int>): List<Theme>

    @Insert
    fun insertAll(themes: List<Theme>)

    @Delete
    fun delete(client: Theme)
}