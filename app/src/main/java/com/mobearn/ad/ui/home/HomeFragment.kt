package com.mobearn.ad.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.MotionEvent.*
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.mobearn.ad.R
import com.mobearn.ad.databinding.FragmentHomeBinding

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.content.Intent as Intent1


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var courseIV: ImageView
    lateinit var courseNameTV: TextView
    lateinit var loadingPB: ProgressBar

    private lateinit var mViewPager: ViewPager2
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewPagerAdapter: SliderAdapter



    //  private var requestQueue: RequestQueue? = null
    var url = "https://mobearn.000webhostapp.com/admin/movie.php"
    var image: String? = null
    var imageurl: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
       // return inflater.inflate(R.layout.fragment_home, container, false)
    }
    private var onImageChangeCallBack = object : ViewPager2.OnPageChangeCallback(){
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val youtube = youtube
        val instagram = instagram
        val webview = WebView
        val movie = button_movie
        val layout = movies
        youtube.setOnClickListener {
            layout.visibility = View.GONE
            webview.webViewClient = WebViewClient()
            webview.settings.javaScriptEnabled = true
            webview.loadUrl("https://www.youtube.com/")
            webview.settings.allowContentAccess = true
            webview.settings.allowFileAccess = true
            webview.visibility = View.VISIBLE
        }
        instagram.setOnClickListener {
            layout.visibility = View.GONE
            webview.webViewClient = WebViewClient()
            webview.settings.javaScriptEnabled = true
            webview.loadUrl("https://www.instagram.com/")
            webview.settings.allowContentAccess = true
            webview.settings.allowFileAccess = true
            webview.visibility = View.VISIBLE
        }
        movie.setOnClickListener {
            layout.visibility = View.VISIBLE

        }


        // var url = "https://mobearn.000webhostapp.com/admin/movie.php"
        val queue: RequestQueue = Volley.newRequestQueue(context)



        val request = JsonArrayRequest(Request.Method.GET, url, null, { response ->

            // this method is called when we get a successful response from API.
            // we are setting the visibility of progress bar as gone.
            // on below line we are adding a try catch block.
            // loadingPB.setVisibility(View.GONE)
            loadingPB = idLoadingPB
            loadingPB.visibility = View.GONE

            try {
               // var imagelist = listOf<String>()
                // on below line we are getting data from our response
                // and setting it in variables.
                /*for(i in 0..response.length()) {
                    imagelist = imagelist+jsonobject[i].getString("Poster")
                    imagelist = imagelist+jsonobject[i].getString("Poster")
                }*/

               // val name = jsonobject.getString("Moviename")

                val jsonobject1 = response.getJSONObject(0)
                val image1 = jsonobject1.getString("Poster")
                val jsonobject2 = response.getJSONObject(1)
                val image2 = jsonobject2.getString("Poster")
                val jsonobject3 = response.getJSONObject(2)
                val image3 = jsonobject3.getString("Poster")
                var imagelist = listOf<String>(image1,image2,image3)
                // val courseName: String = response.getString("Banner")
               // courseNameTV.text = name
                // on below line we are setting
                // image view from image url.

                // on below line we are changing
                // visibility for our button.
                //  visitCourseBtn.visibility = View.VISIBLE
                // on below line we are adding
                // click listener for our button



                mViewPager = binding.slider

                viewPagerAdapter = SliderAdapter(imagelist)

                mViewPager.apply {
                    adapter = viewPagerAdapter
                    registerOnPageChangeCallback(onImageChangeCallBack)
                }

                lifecycleScope.launch {
                    while (true) {
                        for (i in 0..imagelist.size) {
                            delay(2000)
                            if (i == 0) {
                                mViewPager.setCurrentItem(i, false)
                            } else {
                                mViewPager.setCurrentItem(i, true)
                            }
                        }
                    }
                }





            } catch (e: Exception) {
                // on below line we are
                // handling our exception.
                e.printStackTrace()
            }

        }, { error ->
            // this method is called when we get
            // any error while fetching data from our API
            Log.e("TAG", "RESPONSE IS $error")
            // in this case we are simply displaying a toast message.
            Toast.makeText(activity, "Fail to get response", Toast.LENGTH_SHORT).show()

        })




        queue.add(request)





        watch.setOnClickListener {
            val intent = Intent(activity, Watchmovies::class.java)
            startActivity(intent)
        }



    }
    override fun onDestroy() {
        mViewPager.unregisterOnPageChangeCallback(onImageChangeCallBack)
        super.onDestroy()
    }
}
       /* webview.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && event.action === ACTION_UP && webview.canGoBack()) {
                    //  handler.sendEmptyMessage(1)
                    return true
                }
                return false
            }

        })*/






















