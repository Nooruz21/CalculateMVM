package com.example.lovecalculate.di

import com.example.lovecalculate.Prefs.Prefs
import com.example.lovecalculate.Utils
import com.example.lovecalculate.network.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoveApi::class.java)
    }

    @Provides
    fun provideUtils(): Utils {
        return Utils()
    }

    @Provides
    fun providePrefs(): Prefs {
        return Prefs()
    }




}