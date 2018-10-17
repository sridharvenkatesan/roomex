package com.irontec.roomexample.database.entities

import android.arch.persistence.room.*

@Entity
class Theme constructor(uid: Int,themeName: String, themeColor: String, promoCode: String) {

    @PrimaryKey
    var uid: Int = uid

    @ColumnInfo(name = "theme_name")
    var themeName: String = themeName

    @ColumnInfo(name = "theme_color")
    var themeColor: String = themeColor

    @ColumnInfo(name = "promo_code")
    var promoCode: String = promoCode

}