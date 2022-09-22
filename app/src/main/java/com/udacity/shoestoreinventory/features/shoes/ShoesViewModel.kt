package com.udacity.shoestoreinventory.features.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestoreinventory.models.Shoe

class ShoesViewModel : ViewModel() {

    private val _shoeList: MutableList<Shoe> = mutableListOf()

    private var _shoes = MutableLiveData<List<Shoe>>()

    val shoes: LiveData<List<Shoe>>
        get() = _shoes


    fun onSave(name: String, company: String, size: Double, description: String) {
        val newItem = Shoe(name, size, company, description)
        newItem.let { item ->
            _shoeList.add(item)
            _shoes.value = _shoeList
        }
    }
}