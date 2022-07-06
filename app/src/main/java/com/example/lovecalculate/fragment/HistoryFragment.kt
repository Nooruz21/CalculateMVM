package com.example.lovecalculate.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculate.App
import com.example.lovecalculate.HistoryAdapter
import com.example.lovecalculate.R
import com.example.lovecalculate.core.BaseFragment
import com.example.lovecalculate.databinding.FragmentHistoryBinding


class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {
    lateinit var adapter: HistoryAdapter

    override fun inflate(): FragmentHistoryBinding {
        return FragmentHistoryBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeHistory()

    }


    private fun observeHistory() {
        App.db.historyDao().getAll().observe(viewLifecycleOwner) { data ->
            Log.e("ololo", "onViewCreated:$data")
            adapter = HistoryAdapter(data)
            binding.recyclerView.adapter = adapter
        }
    }
}

