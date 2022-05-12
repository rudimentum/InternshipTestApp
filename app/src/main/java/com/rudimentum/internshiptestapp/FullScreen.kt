package com.rudimentum.internshiptestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_full_screen.*

class FullScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)

        val picasso = Picasso.get()
        picasso.load(intent.getStringExtra("image")).into(fullAvatar)
        fullName.text = intent.getStringExtra("name")
        fullStatus.text = intent.getStringExtra("status")
        fullGender.text = intent.getStringExtra("gender")
        fullLocation.text = intent.getStringExtra("location")
        fullEpisodes.text = intent.getStringExtra("episode")
    }
}