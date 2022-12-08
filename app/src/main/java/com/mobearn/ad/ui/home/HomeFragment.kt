package com.mobearn.ad.ui.home

import android.app.ProgressDialog.show
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.MotionEvent.*
import androidx.fragment.app.Fragment
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.mobearn.ad.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*
import org.json.JSONArray
import org.json.JSONException

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
  //  private var requestQueue: RequestQueue? = null
    var url = "https://mobearn.000webhostapp.com/admin/movie.php"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val youtube = youtube
        val instagram = instagram
        val webview= WebView
        val movie= button_movie
        val layout = movies
        youtube.setOnClickListener {
            layout.visibility=View.GONE
            webview.webViewClient= WebViewClient()
            webview.settings.javaScriptEnabled = true
            webview.loadUrl("https://www.youtube.com/")
            webview.getSettings().setAllowContentAccess(true);
            webview.getSettings().setAllowFileAccess(true);
            webview.visibility=View.VISIBLE
        }
        instagram.setOnClickListener {
            layout.visibility=View.GONE
            webview.webViewClient= WebViewClient()
            webview.settings.javaScriptEnabled = true
            webview.loadUrl("https://www.instagram.com/")
            webview.getSettings().setAllowContentAccess(true);
            webview.getSettings().setAllowFileAccess(true);
            webview.visibility=View.VISIBLE
        }
        movie.setOnClickListener {
            layout.visibility=View.VISIBLE

        }





       // var url = "https://mobearn.000webhostapp.com/admin/movie.php"
        val queue: RequestQueue = Volley.newRequestQueue(context)

        courseNameTV = urltv
        courseIV = idIVCourse

        val request = JsonArrayRequest(Request.Method.GET, url, null, { response ->

            // this method is called when we get a successful response from API.
            // we are setting the visibility of progress bar as gone.
            // on below line we are adding a try catch block.
           // loadingPB.setVisibility(View.GONE)
            loadingPB = idLoadingPB
            loadingPB.visibility = View.GONE
            try {
                // on below line we are getting data from our response
                // and setting it in variables.

                val jsonobject = response.getJSONObject(1)
                val name = jsonobject.getString("Moviename")
                val image = jsonobject.getString("Poster")
               // val courseName: String = response.getString("Banner")
                courseNameTV.text= name
                // on below line we are setting
                // image view from image url.
                Picasso.get().load(image).into(courseIV)
                // on below line we are changing
                // visibility for our button.
              //  visitCourseBtn.visibility = View.VISIBLE
                // on below line we are adding
                // click listener for our button.
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
        // at last we are adding
        // our request to our queue.
        queue.add(request)


       /* webview.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && event.action === ACTION_UP && webview.canGoBack()) {
                    //  handler.sendEmptyMessage(1)
                    return true
                }
                return false
            }

        })*/



}
    /*private fun jsonParse() {
        val url = "https://mobearn.000webhostapp.com/admin/movie.php"
        val request = JsonObjectRequest(Request.Method.GET, url, null, {
                response ->try {
            val jsonArray = response.getJSONArray("")
            for (i in 0 until jsonArray.length()) {
                val employee = jsonArray.getJSONObject(i)
                val firstName = employee.getString("Banner")
                urltv.text = firstName


            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        },Response.ErrorListener { error -> error.printStackTrace() })
        requestQueue?.add(request)*/

    }











