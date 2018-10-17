package com.irontec.roomexample.database.daos

import android.arch.persistence.room.*
import com.irontec.roomexample.database.entities.Audio
import com.irontec.roomexample.database.entities.Story

@Dao
interface StoryDao {
    @get:Query("SELECT * FROM story")
    val all: List<Story>

    @Query("SELECT * FROM story WHERE uid IN (:storyId)")
    fun loadAllByIds(storyId: Array<Int>): List<Story>

    @Insert
    fun insertAll(stories: List<Story>)

    @Update
    fun updateStory(stories: List<Story>)

    @Delete
    fun delete(client: Story)
}