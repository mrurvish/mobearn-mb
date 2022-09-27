package com.mobearn.ad.ui.notifications


import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.Toast
import androidx.core.animation.doOnEnd

import com.mobearn.ad.R
import kotlinx.android.synthetic.main.fragment_notifaction.*
import java.io.File

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

var increment = 1
var random = 0


val filename = "myfile.txt"

/**
 * A simple [Fragment] subclass.
 * Use the [NotifactionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class NotifactionFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_notifaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



       val spin = button_spin
            spin.setOnClickListener {

                value()

            }






        }
    fun animation(){
        val animator = ValueAnimator.ofInt(0, 40)
        animator.duration = 5000
        animator.addUpdateListener { animation -> textView3.setText(animation.animatedValue.toString()) }
        animator.start()


    }
    fun value() {

      val data = context?.openFileInput(filename)?.bufferedReader().use {
          it?.readLine().toString()
      }
        val data1= data.toInt()


        val value1 = incr
        val rentext = Rendom
        val animator = ValueAnimator.ofInt(1, 99)
        animator.duration = 1000
        animator.addUpdateListener { animation -> rentext.setText(animation.animatedValue.toString()) }
        animator.repeatCount=1
        animator.repeatMode=ValueAnimator.REVERSE

        animator.start()




        animator.doOnEnd {

        if (increment<30) {

            for (i in 1..1)
            {
                increment++


                rentext.setText(""+ random)
                random = (0 until 20).shuffled().last()

                rentext.setText("" + random)
            }
        }
        else
        {
            Toast.makeText(context,"Come back tomorrow",Toast.LENGTH_LONG).show()
        }

        val increment1 = increment.toString()
        value1.text= increment1
        conslayout1.visibility=View.GONE
        colectlayout.visibility=View.VISIBLE
            textView2.text= random.toString()
        collect.setOnClickListener {
            val filedata = data1 + random
            //  value = data + random
            // textView3.text = value
            //  colectlayout.visibility=View.GONE
            //  conslayout1.visibility=View.VISIBLE
            context?.openFileOutput(filename, Context.MODE_PRIVATE).use {
                it?.write(filedata.toString().toByteArray())
            }
            textView3.text = filedata.toString()
            colectlayout.visibility = View.GONE
            conslayout1.visibility = View.VISIBLE
        }

      //  conslayout1.visibility=View.GONE
      //  colectlayout.visibility=View.VISIBLE
       // collect.setOnClickListener {

            val filedata = data1 + random
          //  value = data + random
           // textView3.text = value
          //  colectlayout.visibility=View.GONE
          //  conslayout1.visibility=View.VISIBLE
        context?.openFileOutput(filename, Context.MODE_PRIVATE).use {
            it?.write(filedata.toString().toByteArray())
        }
        textView3.text=filedata.toString()

    }
    }

    }




