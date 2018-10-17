package com.irontec.roomexample.database.entities

import android.arch.persistence.room.*

@Entity(foreignKeys =
[
    ForeignKey(
            entity = Audio::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("audio_id"),
            onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(
            entity = Moment::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("moment_id"),
            onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(
            entity = Theme::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("theme_id"),
            onDelete = ForeignKey.CASCADE
    )
], indices = [Index(value = "audio_id"), Index(value = "moment_id"), Index(value = "theme_id")]
)
class Story constructor(uid: Int, storyName: String, storyDesc: String, auidoId: Int, momentId: Int, themeId: Int) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = uid

    @ColumnInfo(name = "story_name")
    var storyName: String = storyName

    @ColumnInfo(name = "story_desc")
    var storyDesc: String = storyDesc

    @ColumnInfo(name = "audio_id")
    var auidoId: Int = auidoId

    @ColumnInfo(name = "moment_id")
    var momentId: Int = momentId

    @ColumnInfo(name = "theme_id")
    var themeId: Int = themeId

}