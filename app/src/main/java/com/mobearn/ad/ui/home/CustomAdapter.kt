package com.mobearn.ad.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource



class CustomAdapter( val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    @SuppressLint("NotConstructor")
    fun CustomAdapter(models: List<ColorSpace.Model?>, context: Context) {
       val models = models
        val context = context
    }



    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(com.mobearn.ad.R.layout.card_view_design, parent, false)


        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]


        // sets the image to the imageview from our itemHolder class


            // Create a player instance.



        holder.initPlayer(ItemsViewModel.url)






        // sets the text to the textview from our itemHolder class
       // holder.textView.text = ItemsViewModel.text

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        private var mPlayer: SimpleExoPlayer? = null
          var playerView: PlayerView? = null
        //val textView: TextView = itemView.findViewById(R.id.textView8)

        @SuppressLint("NotConstructor")
        fun ViewHolder(itemView: View) {
            //super(itemView)

             playerView = itemView.findViewById(com.mobearn.ad.R.id.videoplayer)
        }

         fun initPlayer(URL : String) {
             try {
                 // playerView = itemView.findViewById(R.id.videoplayer)
                 playerView = itemView.findViewById(com.mobearn.ad.R.id.videoplayer)
                 // Create a player instance.
                 mPlayer = SimpleExoPlayer.Builder(Watchmovies().baseContext).build()

                 // Bind the player to the view.
                 playerView?.player = mPlayer

                 //setting exoplayer when it is ready.
                 mPlayer!!.playWhenReady = true
                 val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()

                 // Create a progressive media source pointing to a stream uri.
                 val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                     .createMediaSource(MediaItem.fromUri(URL))
                 // Set the media source to be played.
                 mPlayer!!.setMediaSource(mediaSource)

                 // Prepare the player.
                 mPlayer!!.prepare()


                 // Create a data source factory.
             }
             catch (e: java.lang.Exception){

             }


        }
    }







}









//...............................................................

