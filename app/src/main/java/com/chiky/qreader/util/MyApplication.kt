package com.chiky.qreader.util

import android.app.Application
import com.chiky.qreader.data.model.Candidate

class MyApplication: Application() {

    lateinit var currentUser: Candidate
    //lateinit var firebaseAnalytics: FirebaseAnatytics

    //override fun onCreate() {
    //    super.onCreate()
    //    firebaseAnalytics = FirebaseAnalytics.getInstance(this)
    //}
}