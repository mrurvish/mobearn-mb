package com.mobearn.ad.ui.home


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Util
import com.mobearn.ad.R
import kotlinx.android.synthetic.main.activity_watchmovies.view.*


class Watchmovies : AppCompatActivity() {
    lateinit var videoView: VideoView
     var mPlayer: SimpleExoPlayer? = null
     lateinit var playerView: PlayerView
    // on below line we are creating
    // a variable for our video url.
    var videoUrl =
        "https://firebasestorage.googleapis.com/v0/b/mobearn-b981d.appspot.com/o/Movie%2FDoctor%20Strange%20in%20the%20Multiverse%20of%20Madness%20(Hindi)%202022.mp4?alt=media&token=bdc2aefb-57de-4843-8519-68d6b2e38903"
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.mobearn.ad.R.layout.activity_watchmovies)





        // on below line we are
        // simply starting our video view.


        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(com.mobearn.ad.R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view

            data.add(ItemsViewModel("https://firebasestorage.googleapis.com/v0/b/mobearn-b981d.appspot.com/o/Movie%2FDoctor%20Strange%20in%20the%20Multiverse%20of%20Madness%20(Hindi)%202022.mp4?alt=media&token=bdc2aefb-57de-4843-8519-68d6b2e38903"))
            data.add(ItemsViewModel("https://firebasestorage.googleapis.com/v0/b/mobearn-b981d.appspot.com/o/Movie%2FDoctor%20Strange%20in%20the%20Multiverse%20of%20Madness%20(Hindi)%202022.mp4?alt=media&token=bdc2aefb-57de-4843-8519-68d6b2e38903"))
            data.add(ItemsViewModel("https://firebasestorage.googleapis.com/v0/b/mobearn-b981d.appspot.com/o/Movie%2FDoctor%20Strange%20in%20the%20Multiverse%20of%20Madness%20(Hindi)%202022.mp4?alt=media&token=bdc2aefb-57de-4843-8519-68d6b2e38903"))


        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }







}