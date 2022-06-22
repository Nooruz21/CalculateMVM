package com.example.lovecalculate.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.lovecalculate.App
import com.example.lovecalculate.R
import com.example.lovecalculate.databinding.FragmentHomeBinding
import com.example.lovecalculate.network.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
        navController = NavHostFragment.findNavController(this)
    }

    private fun initClickers() {
        with(binding) {
            okBtn.setOnClickListener {
                val firstName = firstEd.text.toString()
                val secondName = secondEd.text.toString()
                App.loveApi.getPercentage(firstName, secondName).enqueue(object :
                    Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            Log.e("ololo", "onResponse:${response.body()?.result}")
                            val bundle = Bundle()

                            bundle.putString("firstName", response.body()?.firstName)
                            bundle.putString("secondName", response.body()?.secondName)
                            bundle.putString("percentage", response.body()?.percentage)
                            bundle.putString("result", response.body()?.result)

                            navController.navigate(R.id.secondFragment, bundle)
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure:${t.message}")
                    }


                })
            }
        }
    }

}