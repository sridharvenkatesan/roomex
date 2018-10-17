package com.irontec.roomexample.database.entities

import android.arch.persistence.room.*

@Entity
class Moment constructor(uid: Int,momentName: String, summary: String) {

    @PrimaryKey
    var uid: Int = uid

    @ColumnInfo(name = "moment_name")
    var momentName: String = momentName;

    @ColumnInfo(name = "summary")
    var summary: String = summary;

}