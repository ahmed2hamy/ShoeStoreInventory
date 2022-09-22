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

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedShoesViewModel = ViewModelProvider(requireActivity())[ShoesViewModel::class.java]


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_details_actions_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_save -> {
            val sizeString: String = binding.shoeSizeEditText.text.toString()
            sharedShoesViewModel.onSave(
                name = binding.shoeNameEditText.text.toString(),
                company = binding.companyEditText.text.toString(),
                size = if (sizeString.isNotEmpty()) sizeString.toDouble() else 0.0,
                description = binding.descriptionEditText.text.toString(),
            )
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