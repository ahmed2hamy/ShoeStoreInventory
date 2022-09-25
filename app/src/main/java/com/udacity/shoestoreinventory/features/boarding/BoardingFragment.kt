package com.udacity.shoestoreinventory.features.boarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestoreinventory.databinding.FragmentBoardingBinding


class BoardingFragment : Fragment() {

    private var _binding: FragmentBoardingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val nextButton = binding.nextToHomeButton

        nextButton.setOnClickListener {
            findNavController().navigate(BoardingFragmentDirections.actionBoardingFragmentToShoesFragment())
        }
    }
}