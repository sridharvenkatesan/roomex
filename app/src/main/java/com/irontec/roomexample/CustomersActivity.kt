package com.irontec.roomexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.irontec.roomexample.adapters.CustomerAdapter
import com.irontec.roomexample.database.AppDatabase
import kotlinx.android.synthetic.main.activity_customer.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CustomersActivity : AppCompatActivity() {

    private var mAdapter: CustomerAdapter? = null
    var url: String = "https://tamil-tunes.com/mp3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        mAdapter = CustomerAdapter(this@CustomersActivity, mutableListOf())
        customer_list.adapter = mAdapter

        doAsync {

            val database = AppDatabase.getInstance(context = this@CustomersActivity)
            val stories = database.storyDao().all
            val audios = database.audioDao().all
            for (audio in audios) {
//                println("audio_details" + audio.audioName + "::" + audio.uid + "::" + audio.storyId)
            }
            uiThread {
                mAdapter!!.addAll(stories)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.empty, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
