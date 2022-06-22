package com.example.lovecalculate

import android.app.Application
import com.example.lovecalculate.network.LoveApi
import com.example.lovecalculate.network.RetrofitService

class App : Application() {
    companion object {
        lateinit var loveApi: LoveApi

    }

    override fun onCreate() {
        super.onCreate()
        val retrofitService = RetrofitService()
        loveApi = retrofitService.getApi()
    }
}