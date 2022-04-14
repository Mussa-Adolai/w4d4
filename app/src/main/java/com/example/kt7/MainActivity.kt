package com.example.kt7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

   var bottomNav:BottomNavigationView? = null
    var frameLayout:FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNav)
        frameLayout = findViewById(R.id.fContainer)

        bottomnavClicks()
        ChooseFragment(Home(),"HOME")   // to show home fragment first by default

    }

    private fun bottomnavClicks() {
        bottomNav?.setOnItemSelectedListener(){

            when(it.itemId){
                R.id.home -> {
                    ChooseFragment(Home(),"HOME")
                }
                R.id.setting->{
                    ChooseFragment(SettingFragment(),"SETTING")
                }
                R.id.profile->{
                    ChooseFragment(ProfileFragment(),"PROFILE")
                }
            }
            true

        }

    }


    fun ChooseFragment(fragment: Fragment ,tag : String){
        val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fContainer,fragment,tag)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.commit()
    }

}