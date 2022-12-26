package com.mobearn.ad

import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mobearn.ad.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.fragment_home.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

       // val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_bank,R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val filename = "/data/data/com.mobearn.ad/files/myfile.txt"
        val sdf = SimpleDateFormat("dd")
        val currentDate = sdf.format(Date())
        if(File(filename).exists())
        {

        }
        else
        {
            applicationContext.openFileOutput(com.mobearn.ad.ui.notifications.filename, Context.MODE_PRIVATE).use {
                it?.write("0".toByteArray())
            }
        }
        val datefile = "/data/data/com.mobearn.ad/files/datefile.txt"
        if(File(datefile).exists())
        {

        }
        else
        {
            applicationContext.openFileOutput(com.mobearn.ad.ui.notifications.datefile, Context.MODE_PRIVATE).use {
                it?.write("0".toByteArray())
            }
        }
        val incrfile = "/data/data/com.mobearn.ad/files/incrfile.txt"
        if(File(incrfile).exists())
        {

        }
        else
        {
            applicationContext.openFileOutput(com.mobearn.ad.ui.notifications.incrfile, Context.MODE_PRIVATE).use {
                it?.write("0".toByteArray())
            }
        }

    }

}

