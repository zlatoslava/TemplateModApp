package com.squidgamepp.templatemodapp

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val onReceivedBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
//            uriToDownload = null

            Snackbar.make(nav_host_fragment, R.string.file_was_downloaded, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.open_folder) {
                    startActivity(Intent(DownloadManager.ACTION_VIEW_DOWNLOADS))
                }
                .show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerReceiver(
            onReceivedBroadcastReceiver,
            IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        )

//        initializeAds()
    }

    override fun onDestroy() {
        try {
            unregisterReceiver(onReceivedBroadcastReceiver)
        } catch (ex: Exception) {

        }
        super.onDestroy()
    }

    private fun initializeAds() {
//        MobileAds.initialize(this) {}
//        val testDeviceIds = Arrays.asList("D37A55507A63B5E94A134B5BE527F18B")
//        val configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
//        MobileAds.setRequestConfiguration(configuration)
    }
}