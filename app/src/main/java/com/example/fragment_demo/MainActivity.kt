package com.example.fragment_demo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.fragment_demo.Fragments.HomeFragment
import com.example.fragment_demo.Fragments.TodoFragment
import com.example.mvvm_coroutine_kotlin.Network.NetworkConnection
import com.example.mvvm_coroutine_with_fragment_kotlin.Fragments.ProfileFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {
    private lateinit var networkConnection: NetworkConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ///check Internet
        networkConnection = NetworkConnection(application)
        networkConnection.observe(this, Observer {
            when (it) {
                true -> {
                    val snackbar =
                        Snackbar.make(id_layout, "You are in Online!", Snackbar.LENGTH_SHORT)
                    val view = snackbar.view
                    view.setBackgroundColor(ContextCompat.getColor(this, R.color.grean))
                    snackbar.show()
                }
                false -> {
                    val snackbar =
                        Snackbar.make(id_layout, "You are in Offline!!", Snackbar.LENGTH_SHORT)
                    val view = snackbar.view
                    view.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
                    snackbar.show()
                }
            }
        })

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout, HomeFragment())
                        commit()
                    }
                }
                R.id.nav_search -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout, TodoFragment())
                        commit()
                    }
                }
                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout, ProfileFragment())
                        commit()
                    }
                }
            }
            true
        }
        bottom_navigation.selectedItemId = R.id.nav_home

    }

}