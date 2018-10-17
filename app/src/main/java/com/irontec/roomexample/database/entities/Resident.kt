package com.irontec.roomexample.database.entities

import android.arch.persistence.room.*

@Entity
class Resident constructor(uid: Int, residentName: String, emailId: String, communityName: String, companyName: String, profilePicUrl: String) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = uid

    @ColumnInfo(name = "resident_name")
    var residentName: String = residentName;

    @ColumnInfo(name = "email_id")
    var emailId: String = emailId

    @ColumnInfo(name = "community_name")
    var communityName: String = communityName

    @ColumnInfo(name = "companyName")
    var companyName: String = companyName

    @ColumnInfo(name = "profile_pic_url")
    var profilePicUrl: String = profilePicUrl
}