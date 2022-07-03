package com.example.lovecalculate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculate.network.model.LoveModel
import com.example.lovecalculate.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun getLiveLoveModel(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        return repository.getMutableLiveDataOfLoveModel(
            firstName,
            secondName
        )
    }
}