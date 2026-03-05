package com.axiel7.moelist

import android.app.Application

class MoeListApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initApp(context = applicationContext)
    }
}
