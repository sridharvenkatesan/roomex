package com.irontec.roomexample.database.entities

import android.arch.persistence.room.*

@Entity(foreignKeys =
[
    ForeignKey(
            entity = Resident::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("resident_id"),
            onDelete = ForeignKey.CASCADE
    )
], indices = [Index(value = "resident_id")])
class Recipient constructor(uid: Int,recipientName: String, emailId: String, residentId: Int) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = uid

    @ColumnInfo(name = "recipient_name")
    var recipientName: String = recipientName

    @ColumnInfo(name = "email_id")
    var emailId: String = emailId

    @ColumnInfo(name = "resident_id")
    var residentId: Int = residentId

}