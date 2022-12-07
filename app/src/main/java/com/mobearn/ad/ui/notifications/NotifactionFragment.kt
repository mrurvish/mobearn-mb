package com.mobearn.ad.ui.notifications


import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
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
import java.util.*
import com.mobearn.ad.ui.notifications.random as random1
import java.text.SimpleDateFormat as SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

var increment = 0
var random = 0


val filename = "myfile.txt"
val datefile = "datefile.txt"
val incrfile="incrfile.txt"
val sdf = SimpleDateFormat("dd")
val currentDate = sdf.format(Date())

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

        val data = context?.openFileInput(filename)?.bufferedReader().use {
            it?.readLine().toString()
        }
        textView3.text=data
        val incrdat = context?.openFileInput(incrfile)?.bufferedReader().use {
            it?.readLine().toString()
        }
        incr.text=incrdat


            button_spin.setOnClickListener {

                value()

            }
       // textView6.text= currentDate

        val datecheck = context?.openFileInput(datefile)?.bufferedReader().use {
            it?.readLine().toString()
        }
        if (currentDate != datecheck)
        {
            context?.openFileOutput(incrfile, Context.MODE_PRIVATE).use {
                it?.write("0".toByteArray())

            }
        }
        else
        {

        }




        }



    fun value() {
        val incrdat = context?.openFileInput(incrfile)?.bufferedReader().use {
            it?.readLine().toString()
        }



        var incrdata = incrdat.toInt()

        if(incrdata==30)
        {
            context?.openFileOutput(datefile, Context.MODE_PRIVATE).use {
                it?.write(currentDate.toByteArray())
            }
        }

      val data = context?.openFileInput(filename)?.bufferedReader().use {
          it?.readLine().toString()
      }


        val data1= data.toInt()


        val value1 = incr
        val rentext = Rendom


        if (incrdata<30) {
            val animator = ValueAnimator.ofInt(0, 10)
            animator.duration = 50
            animator.addUpdateListener { animation -> rentext.setText(animation.animatedValue.toString()) }
            animator.repeatCount = 1
            animator.repeatMode = ValueAnimator.REVERSE

            animator.start()

        animator.doOnEnd {

        if (incrdata<30) {



            for (i in 1..1)
            {
               incrdata= incrdata+1

                value1.text= incrdata.toString()
                rentext.setText(""+ random1)
                random1 = (0 until 20).shuffled().last()

                rentext.setText("" + random1)
                context?.openFileOutput(incrfile, Context.MODE_PRIVATE).use {
                    it?.write(incrdata.toString().toByteArray())

                }

            }






            var point: Int = 0
            if(random1==1 ||  random1==8 || random1==14)
            {
                point = 3
            }
            else if (random1==2 ||  random1==16)
            {
                point = 4
            }
            else if (random1==3 ||  random1==11)
            {
                point = 5
            }
            else if (random1==4)
            {
                point = 7
            }
            else if (random1==5 ||  random1==10 || random1==19)
            {
                point = 1
            }
            else if (random1==7 )
            {
                point = 8
            }
            else if (random1==9 ||  random1==18 || random1==13)
            {
                point = 2
            }
            else if (random1==12 )
            {
                point = 6
            }
            else if (random1==15 )
            {
                point = 9
            }
            else if (random1==20 )
            {
                point = 10
            }
            else
            {
                point = 0
            }




        conslayout1.visibility=View.INVISIBLE
        colectlayout.visibility=View.VISIBLE
            textView2.text= point.toString()
        collect.setOnClickListener {
            val filedata = data1 + point
            //  value = data + random
            // textView3.text = value
            //  colectlayout.visibility=View.GONE
            //  conslayout1.visibility=View.VISIBLE
            context?.openFileOutput(filename, Context.MODE_PRIVATE).use {
                it?.write(filedata.toString().toByteArray())
            }
            textView3.text = filedata.toString()
            colectlayout.visibility = View.INVISIBLE
            conslayout1.visibility = View.VISIBLE
        }

      //  conslayout1.visibility=View.GONE
      //  colectlayout.visibility=View.VISIBLE
       // collect.setOnClickListener {

            val filedata = data1 + random1
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
        else
        {
            Toast.makeText(context,"Come back tomorrow",Toast.LENGTH_LONG).show()
        }
    }

    }




