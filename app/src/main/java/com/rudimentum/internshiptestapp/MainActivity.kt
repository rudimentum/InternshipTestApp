package com.rudimentum.internshiptestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.rudimentum.internshiptestapp.adapter.CustomRecyclerAdapter
import com.rudimentum.internshiptestapp.model.HomeFeed
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView.layoutManager = LinearLayoutManager(this)

        fetchJSON()
    }

    private fun fetchJSON() {
        val url = "https://rickandmortyapi.com/api/character"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()
                val homeFeed: HomeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    myRecyclerView.adapter = CustomRecyclerAdapter(homeFeed)
                }
            }
        })
    }

}