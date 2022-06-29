package com.example.lovecalculate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculate.network.model.LoveModel
import com.example.lovecalculate.repository.Repository

class LoveViewModel : ViewModel() {

   private val repository = Repository()

    fun getLiveLoveModel(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        return repository.getMutableLiveDataOfLoveModel(
            firstName,
            secondName
        )
    }
}