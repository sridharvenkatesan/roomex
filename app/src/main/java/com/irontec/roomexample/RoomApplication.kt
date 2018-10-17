package com.irontec.roomexample

import android.app.Application
import com.irontec.roomexample.database.AppDatabase
import com.irontec.roomexample.database.entities.*
import org.jetbrains.anko.doAsync

/**
 * Created by axier on 7/2/18.
 */

class RoomApplication : Application() {
    var url: String = "https://tamil-tunes.com/mp3"
    override fun onCreate() {
        super.onCreate()
        /*  doAsync {

                 if (database.audioDao().all.isEmpty()) {
                     val audios: MutableList<Audio> = mutableListOf()
                     for (index: Int in 0..20) {
                         val client = Audio(audioName = "audio" + index, audioUrl = url + index, storyId = stories.get(index).uid)
                         audios.add(index, client)
                     }
                     database.audioDao().insertAll(audios = audios)
                 }*/

        /* if (database.themeDao().all.isEmpty()) {
             val themes: MutableList<Theme> = mutableListOf()
             for (index: Int in 0..20) {
                 val client = Theme(themeName = "theme" + index, themeColor = "#FFFFF" + index, promoCode = "267" + index, storyId = stories.get(index).uid)
                 themes.add(index, client)
             }
             database.themeDao().insertAll(themes = themes)
         }

         if (database.momentDao().all.isEmpty()) {
             val moments: MutableList<Moment> = mutableListOf()
             lateinit var client: Moment
             for (index: Int in 0..20) {
                 if (index % 2 == 0 && index < 10) {
                     client = Moment(momentName = "moment" + index, summary = "summary" + index, storyId = stories.get(7).uid)
                 } else if (index % 2 == 1 && index < 10) {
                     client = Moment(momentName = "moment" + index, summary = "summary" + index, storyId = stories.get(8).uid)
                 } else {
                     client = Moment(momentName = "moment" + index, summary = "summary" + index, storyId = stories.get(5).uid)
                 }
                 moments.add(index, client)
             }
             database.momentDao().insertAll(moments = moments)
         }

         if (database.residentDao().all.isEmpty()) {
             for (index: Int in 0..20) {
                 val client = Resident(residentName = "resident" + index, emailId = "resident" + index + "@gmail.com", communityName = "community" + index, companyName = "company" + index,
                         profilePicUrl = url + index, storyId = stories.get(index).uid)
                 residents.add(index, client)
             }
             database.residentDao().insertAll(residents = residents)
         }

         if (database.recipientDao().all.isEmpty()) {
             val recipients: MutableList<Recipient> = mutableListOf()
             for (index: Int in 0..20) {
                 val client = Recipient(recipientName = "recipient" + index, emailId = "recipient" + index + "@gmail.com", residentId = residents.get(index).uid)
                 recipients.add(index, client)
             }
             database.recipientDao().insertAll(recipients = recipients)
         }*/
    }

}
