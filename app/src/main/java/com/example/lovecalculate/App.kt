package com.example.lovecalculate

import android.app.Application
import androidx.room.Room
import com.example.lovecalculate.network.LoveApi
import com.example.lovecalculate.network.RetrofitService
import com.example.lovecalculate.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object{
    lateinit var db: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this, AppDataBase::class.java,
            "love-base"
        ).allowMainThreadQueries().build()
    }

}