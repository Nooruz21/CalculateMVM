package com.example.lovecalculate.di

import android.content.Context
import androidx.room.Room
import com.example.lovecalculate.Prefs.Prefs
import com.example.lovecalculate.Utils
import com.example.lovecalculate.network.LoveApi
import com.example.lovecalculate.room.AppDataBase
import com.example.lovecalculate.room.HistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


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

        @Provides
        fun  provideAppDataBase(@ApplicationContext context: Context) : AppDataBase {
            return Room.databaseBuilder(context,AppDataBase::class.java ,"database").
            allowMainThreadQueries().fallbackToDestructiveMigration().build()

        }

    @Provides
    fun provideHistoryDao(appDataBase: AppDataBase): HistoryDao {
        return appDataBase.historyDao()
    }




}