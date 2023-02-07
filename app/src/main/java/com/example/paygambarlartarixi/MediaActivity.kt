package com.example.paygambarlartarixi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.button.MaterialButton
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class MediaActivity : YouTubeBaseActivity() {

    val video_id = ArrayList<String>()
    val youtube_api_key = "AIzaSyCC9CmkoX7mHt8ky_Op6dYOiznQD5vLe7A"

    private lateinit var youtubePlayer: YouTubePlayerView
    private lateinit var btnPlay: MaterialButton

    private lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        var position = intent.getStringExtra("position").toString().toInt()

        video_id.add("upiS93DCR6o")
        video_id.add("ynZZFIZCGPA")
        video_id.add("JpicpEOZhLk")
        video_id.add("XoU3mM6wOZQ")
        video_id.add("mxo3zGlvHg4")
        video_id.add("peE49AmJ3b4")
        video_id.add("KNCemOqBsDU")
        video_id.add("frIoEj8L3S0")
        video_id.add("NPyyvMiuUA0")
        video_id.add("DxS7AAaSBMQ")
        video_id.add("qY35vNKQiNM")
        video_id.add("glT7orBaJwU")
        video_id.add("JUJK532-QNY")
        video_id.add("UeYLISeZF6M")
        video_id.add("BFihxtJoSxQ")
        video_id.add("iBvMVWOo4")
        video_id.add("78XwUDmLJhs")
        video_id.add("dmM_M6locUA")
        video_id.add("rXFobgF872o")
        video_id.add("EwV1ZtSdZTY")
        video_id.add("ymcoOl3UMoY")
        video_id.add("ZxJHRF2bMmQ")
        video_id.add("rCBikVurD0I")
        video_id.add("hm-uEYyq1B8")
        video_id.add("FD8aa5Y5BoY")
        video_id.add("hQoP6wxUDhs")
        video_id.add("LwKQqHQVGU8")
        video_id.add("dcWW2TDqmdg")
        video_id.add("1e1FN5HHVgY")
        video_id.add("YMvRFsNaY6I")

        youtubePlayer = findViewById(R.id.videoView)
        btnPlay = findViewById(R.id.btnplay2)

        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo(video_id[position])
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }

        }

        btnPlay.setOnClickListener {
            btnPlay.isVisible = false
            youtubePlayer.initialize(youtube_api_key, youtubePlayerInit)

        }

    }
}