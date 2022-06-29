package com.example.lovecalculate.repository

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.lovecalculate.App
import com.example.lovecalculate.R
import com.example.lovecalculate.network.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getMutableLiveDataOfLoveModel(
        firstName: String,
        secondName: String
    ): MutableLiveData<LoveModel> {
        val liveLoveModel :MutableLiveData<LoveModel> = MutableLiveData()
        App.loveApi.getPercentage(firstName,secondName).enqueue(object :
            Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let {
                    liveLoveModel.postValue(it)
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
               Log.e("ololo","onFailure:${t.message}")
            }

        })
        return liveLoveModel
    }
}
