package com.example.fetchproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchproject.model.ItemData
import com.example.fetchproject.network.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel: ViewModel() {

    private val repository: ItemRepository = ItemRepository()
    private var _itemLiveDataList: MutableLiveData<List<ItemData>> = MutableLiveData()
    val itemLiveData: LiveData<List<ItemData>> = _itemLiveDataList

    fun getDataFromRepository() {
        viewModelScope.launch(Dispatchers.IO) {
            _itemLiveDataList.postValue(repository.fetchData())
        }
    }
}