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

    private var _shoe = MutableLiveData(Shoe())
    val shoe: LiveData<Shoe>
        get() = _shoe


    fun onSave() {

        _shoe.value?.let {
            _shoeList.add(it)
            _shoes.value = _shoeList
        }
        _shoe = MutableLiveData(Shoe())

    }
}