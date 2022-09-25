package com.udacity.shoestoreinventory.features.shoes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestoreinventory.R
import com.udacity.shoestoreinventory.databinding.FragmentShoesBinding
import com.udacity.shoestoreinventory.databinding.ShoeDetailsBinding

class ShoesFragment : Fragment() {


    private var _binding: FragmentShoesBinding? = null

    private val binding get() = _binding!!

    private lateinit var sharedShoesViewModel: ShoesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoesBinding.inflate(inflater, container, false)


        sharedShoesViewModel = ViewModelProvider(requireActivity())[ShoesViewModel::class.java]
        setHasOptionsMenu(true)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ShoesFragmentDirections.actionShoesFragmentToShoeDetailsFragment())
        }


        sharedShoesViewModel.shoes.observe(viewLifecycleOwner) { shoes ->
            if (shoes.isEmpty()) {
                binding.noShoesTextView.visibility = View.VISIBLE
            } else {
                binding.noShoesTextView.visibility = View.GONE
            }
            shoes.forEach { shoe ->
                val shoeDetailsBinding: ShoeDetailsBinding =
                    ShoeDetailsBinding.inflate(inflater, container, false)
                shoe.name = shoe.name ?: ""
                shoe.company = shoe.company ?: ""
                shoe.size = shoe.size ?: 0.0
                shoe.description = shoe.description ?: ""
                shoeDetailsBinding.shoe = shoe
                binding.shoeList.addView(shoeDetailsBinding.root)
            }
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.logout_menu -> {
                findNavController().navigate(ShoesFragmentDirections.actionShoesFragmentToLogoutMenu())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


}