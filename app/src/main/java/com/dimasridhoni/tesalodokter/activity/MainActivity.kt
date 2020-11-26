/*
 * *
 *  * Created by Dimas Ridhoni on 11/26/20 3:31 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 11/26/20 11:26 AM
 *
 */

package com.dimasridhoni.tesalodokter.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dimasridhoni.tesalodokter.R

class MainActivity : AppCompatActivity() {

    internal var sharedPreferences: SharedPreferences? =null
    internal val mypreferenceUser = "myprefUser"
    internal val userIdKey      = "userIdKey"
    internal val statusLoginKey = "statusLoginKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home,
            R.id.navigation_dashboard
        ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        sharedPreferences = getSharedPreferences(mypreferenceUser, Context.MODE_PRIVATE)
    }
}