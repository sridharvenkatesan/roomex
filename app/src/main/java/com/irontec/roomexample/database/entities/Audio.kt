package com.irontec.roomexample.database.entities

import android.arch.persistence.room.*

@Entity
class Audio constructor(uid: Int, audioName: String, audioUrl: String) {

    @PrimaryKey
    var uid: Int = uid

    @ColumnInfo(name = "audio_name")
    var audioName: String = audioName

    @ColumnInfo(name = "audio_url")
    var audioUrl: String = audioUrl

}