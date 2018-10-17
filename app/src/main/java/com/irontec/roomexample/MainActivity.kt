package com.irontec.roomexample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import com.irontec.roomexample.database.AppDatabase
import com.irontec.roomexample.database.entities.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = AppDatabase.getInstance(context = this@MainActivity)
        val residents: MutableList<Resident> = mutableListOf()
        var url: String = "https://tamil-tunes.com/mp3"

        /*store_stories.setOnClickListener({ _ ->
            doAsync {
                val stories: MutableList<Story> = mutableListOf()
                if (database.storyDao().all.isEmpty()) {
                    for (index: Int in 0..20) {
                        val client = Story(uid = index + 1, storyName = "story" + index, storyDesc = "description" + index, auidoId = 0, momentId = 0, themeId = 0)
                        stories.add(index, client)
                    }
                    database.storyDao().insertAll(stories = stories)
                    val storiesStored = database.storyDao().all as MutableList<Story>
                    println("size" + storiesStored.size)
                }
            }
        })*/

        get_story_info.setOnClickListener({ _ ->
            doAsync {
                val stories = database.storyDao().all
                val audios = database.audioDao().all
                val moments = database.momentDao().all
                val themes = database.themeDao().all
                val storiesUpdate: MutableList<Story> = mutableListOf()
                for (story in stories) {
                    val audio: Audio = AppDatabase.getInstance(context = this@MainActivity)
                            .audioDao()
                            .loadAllByIds(arrayOf(story.auidoId))
                            .first()
                    val moment: Moment = AppDatabase.getInstance(context = this@MainActivity)
                            .momentDao()
                            .loadAllByIds(arrayOf(story.momentId))
                            .first()
                    val theme: Theme = AppDatabase.getInstance(context = this@MainActivity)
                            .themeDao()
                            .loadAllByIds(arrayOf(story.themeId))
                            .first()
                    println("story name--" + story.storyName + "--story desc--" + story.storyDesc + "--audio name--" + audio.audioName + "--moment name--" + moment.momentName +
                            "--theme name" + theme.themeName + "--theme color--" + theme.themeColor)
                }
            }
        })

        store_audio.setOnClickListener({ _ ->
            doAsync {
                if (database.audioDao().all.isEmpty()) {
                    val stories = database.storyDao().all
                    val audios: MutableList<Audio> = mutableListOf()
                    for (index: Int in 0..20) {
                        val client = Audio(uid = index, audioName = "audio" + index, audioUrl = url + index)
                        audios.add(index, client)
                    }
                    database.audioDao().insertAll(audios = audios)
                }
            }
        })

        store_moments.setOnClickListener({ _ ->
            doAsync {

                if (database.momentDao().all.isEmpty()) {
                    val stories = database.storyDao().all
                    val moments: MutableList<Moment> = mutableListOf()
                    lateinit var client: Moment
                    for (index: Int in 0..20) {
                        if (index % 2 == 0 && index < 10) {
                            client = Moment(uid = index, momentName = "moment" + index, summary = "summary" + index)
                        } else if (index % 2 == 1 && index < 10) {
                            client = Moment(uid = index, momentName = "moment" + index, summary = "summary" + index)
                        } else {
                            client = Moment(uid = index, momentName = "moment" + index, summary = "summary" + index)
                        }
                        moments.add(index, client)
                    }
                    database.momentDao().insertAll(moments = moments)
                }
            }
        })

        store_themes.setOnClickListener({ _ ->
            doAsync {
                if (database.themeDao().all.isEmpty()) {
                    val stories = database.storyDao().all
                    val themes: MutableList<Theme> = mutableListOf()
                    for (index: Int in 0..20) {
                        val client = Theme(uid = index, themeName = "theme" + index, themeColor = "#FFFFF" + index, promoCode = "267" + index)
                        themes.add(index, client)
                    }
                    database.themeDao().insertAll(themes = themes)
                }
            }
        })

    }


    private fun saveAmount(amount: String, customer: Customer) {
        doAsync {
            val bill = Bill(amount = Integer.valueOf(amount), customerId = customer.uid)
            AppDatabase.getInstance(this@MainActivity).billDao().insert(bill)
        }
    }
}
