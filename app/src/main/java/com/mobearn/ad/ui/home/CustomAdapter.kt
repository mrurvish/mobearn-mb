package com.mobearn.ad.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.ColorSpace
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ExoPlayer
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
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){

       // val simpleExoPlayer: ExoPlayer = itemView.findViewById(com.mobearn.ad.R.id.videoplayer)
        private var playerView: PlayerView = itemView.findViewById(com.mobearn.ad.R.id.videoplayer)
        //val textView: TextView = itemView.findViewById(R.id.textView8)
        private lateinit var exoPlayer: SimpleExoPlayer
        @SuppressLint("NotConstructor")

            //super(itemView)




         fun initPlayer(URL : String) {

             exoPlayer = SimpleExoPlayer.Builder(itemView.context).build()
             playerView.player = this.exoPlayer
             val mediaUri = Uri.parse(URL)
             val mediaItem =MediaItem.fromUri(mediaUri)
             exoPlayer.addMediaItem(mediaItem)
             exoPlayer.prepare()
            // exoPlayer.playWhenReady=true


        }
    }







}









//...............................................................

