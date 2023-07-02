package com.example.radius.data.persistence

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("radius.realm")
            .build()
        // encryption not added as of now
        Realm.setDefaultConfiguration(config)
    }
}