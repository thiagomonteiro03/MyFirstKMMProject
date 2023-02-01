package com.example.getstartedkmm

import android.app.Application

// Located in the native androidApp code
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initContextForSharedAndroidCode()
    }

    private fun initContextForSharedAndroidCode() {
        // Variable from the Context.kt file
        appContext = this
    }
}