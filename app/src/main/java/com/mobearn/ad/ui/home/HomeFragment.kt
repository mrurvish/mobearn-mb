package com.mobearn.ad.ui.home

import android.os.Bundle
import android.view.*
import android.view.MotionEvent.*
import androidx.fragment.app.Fragment
import android.webkit.WebViewClient
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import com.mobearn.ad.R
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters


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
        webview.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && event.action === ACTION_UP && webview.canGoBack()) {
                    //  handler.sendEmptyMessage(1)
                    return true
                }
                return false
            }

        })



}
}
