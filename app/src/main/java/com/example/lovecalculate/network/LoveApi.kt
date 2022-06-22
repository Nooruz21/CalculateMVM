package com.example.lovecalculate.network

import com.example.lovecalculate.network.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

import retrofit2.http.Query

interface LoveApi {
    @GET( "getPercentage")
    fun getPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key:String="02c47a52b1mshc75ae1ff37cc0bep138379jsnd9889471f9be",
        @Header("X-RapidAPI-Host" ) host:String="love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}