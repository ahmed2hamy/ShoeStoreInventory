package com.udacity.shoestoreinventory.features.shoe_details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestoreinventory.R
import com.udacity.shoestoreinventory.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestoreinventory.features.shoes.ShoesViewModel

class ShoeDetailsFragment : Fragment() {

    private var _binding: FragmentShoeDetailsBinding? = null

    private val binding get() = _binding!!

    private lateinit var sharedShoesViewModel: ShoesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)

        sharedShoesViewModel = ViewModelProvider(requireActivity())[ShoesViewModel::class.java]

        binding.viewModel = sharedShoesViewModel

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_details_actions_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_save -> {
            sharedShoesViewModel.onSave()
            findNavController().popBackStack()
            true
        }

        R.id.action_cancel -> {
            findNavController().popBackStack()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

}