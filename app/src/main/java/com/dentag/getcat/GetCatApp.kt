package com.dentag.getcat

import android.app.Application

class GetCatApp : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: GetCatApp
            private set
    }
}
