package com.mobearn.ad.ui.home

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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



        // on below line we are
        // simply starting our video view.


        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..3) {
            data.add(ItemsViewModel(R.drawable.ic_baseline_account_circle_24, "Item " + i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }
}