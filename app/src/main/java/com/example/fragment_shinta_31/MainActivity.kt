package com.example.fragment_shinta_31

import android.os.Bundle;
import android.os.Parcel
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragment_shinta_31.R.id.bottom_navigation
import com.example.fragment_shinta_31.fragment.HomeFragment
import com.example.fragment_shinta_31.fragment.NotificationsFragment
import com.example.fragment_shinta_31.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


public class MainActivity(parcel: Parcel) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notificationsFragment = NotificationsFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment (homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_notifications -> makeCurrentFragment(notificationsFragment)
                R.id.menu_setting -> makeCurrentFragment(settingsFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }
    }
}