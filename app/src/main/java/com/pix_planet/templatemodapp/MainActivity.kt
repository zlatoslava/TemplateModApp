package com.pix_planet.templatemodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        initializeAds()
    }

    private fun initializeAds() {
//        MobileAds.initialize(this) {}
//        val testDeviceIds = Arrays.asList("D37A55507A63B5E94A134B5BE527F18B")
//        val configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
//        MobileAds.setRequestConfiguration(configuration)
    }
}