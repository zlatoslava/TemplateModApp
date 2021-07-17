package com.pix_planet.templatemodapp

import android.app.Application
import com.pix_planet.templatemodapp.utils.AppOpenManager
import com.google.android.gms.ads.MobileAds


class MyApplication: Application() {

    private var appOpenManager: AppOpenManager? = null

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) {}
        appOpenManager = AppOpenManager(this)
    }
}