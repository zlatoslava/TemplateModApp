package com.squidgamepp.templatemodapp

import android.app.Application
import com.squidgamepp.templatemodapp.utils.AppOpenManager
import com.google.android.gms.ads.MobileAds


class MyApplication: Application() {

    private var appOpenManager: AppOpenManager? = null

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) {}
        appOpenManager = AppOpenManager(this)
    }
}