package com.example.lovecalculate.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculate.Board
import com.example.lovecalculate.Prefs.Prefs
import com.example.lovecalculate.R
import com.example.lovecalculate.databinding.FragmentBoardBinding
import javax.inject.Inject


class BoardFragment : Fragment() {

    private lateinit var binding: FragmentBoardBinding
    private lateinit var adapter: BoardAdapter

    @Inject
    var prefs: Prefs? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BoardAdapter(requireContext(), findNavController())
        binding.viewPager.adapter = adapter
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner) {
            activity?.finish()
        }
        adapter.addItem(
            Board(
                R.raw.board_love,
                "Have a good time",
                "You should take the time to help those who need you"
            )
        )
        adapter.addItem(
            Board(
                R.raw.board_love2,
                "Cherishing love",
                "It is now no longer possible for you to cherish love"
            )
        )
        adapter.addItem(
            Board(
                R.raw.board_love3,
                "Have a breakup?",
                "We have made the correction for you don't worry\nMaybe someone is waiting for you!"
            )
        )
        adapter.addItem(Board(R.raw.board_love4, "", "It's Fans and Many more"))

        binding.textSkip.setOnClickListener {
            prefs?.saveState()
            findNavController().navigateUp()
        }
    }
}