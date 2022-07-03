package com.example.lovecalculate.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculate.Board
import com.example.lovecalculate.Prefs.Prefs
import com.example.lovecalculate.databinding.ItemBoardBinding
import javax.inject.Inject


class BoardAdapter(val context: Context, val navController: NavController) :
    RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {

    private val data = arrayListOf<Board>()

    @Inject
    var prefs: Prefs? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(
            ItemBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
    fun addItem(board: Board) {
        data.add(board)
    }

    inner class BoardViewHolder(private var binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(board: Board) {
            binding.animationView.setAnimation(board.lottie)
            binding.textTitle.text = board.title
            binding.textDesc.text = board.description

            if (data.lastIndexOf(board) == data.lastIndex) {
                binding.btnStart.visibility = View.VISIBLE
            } else {
                binding.btnStart.visibility = View.INVISIBLE
            }
            binding.btnStart.setOnClickListener {
                prefs?.saveState()
                navController.navigateUp()
            }
        }
    }
}