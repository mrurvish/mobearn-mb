package com.mobearn.ad.ui.home

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.mobearn.ad.R

class Watchmovies : AppCompatActivity() {
    lateinit var videoView: VideoView

    // on below line we are creating
    // a variable for our video url.
    var videoUrl =
        "https://firebasestorage.googleapis.com/v0/b/mobearn-b981d.appspot.com/o/Movie%2FDoctor%20Strange%20in%20the%20Multiverse%20of%20Madness%20(Hindi)%202022.mp4?alt=media&token=bdc2aefb-57de-4843-8519-68d6b2e38903"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watchmovies)


        videoView = findViewById(R.id.videoView);

        // on below line we are creating
        // uri for our video view.
        val uri: Uri = Uri.parse(videoUrl)

        // on below line we are setting
        // video uri for our video view.
        videoView.setVideoURI(uri)

        // on below line we are creating variable
        // for media controller and initializing it.
        val mediaController = MediaController(this)

        // on below line we are setting anchor
        // view for our media controller.
        mediaController.setAnchorView(this.videoView)

        // on below line we are setting media player
        // for our media controller.
        mediaController.setMediaPlayer(this.videoView)

        // on below line we are setting media
        // controller for our video view.
        this.videoView.setMediaController(mediaController)

        // on below line we are
        // simply starting our video view.

    }
}