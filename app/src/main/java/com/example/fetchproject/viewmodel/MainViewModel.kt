package com.example.fetchproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchproject.model.DataResult
import com.example.fetchproject.model.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val repository: MainRepository = MainRepository()
) : ViewModel() {

    private val _itemDataStateFlow: MutableStateFlow<DataResult> =
        MutableStateFlow(DataResult.Empty)
    val itemDataStateFlow: StateFlow<DataResult> = _itemDataStateFlow.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.fetchData()
            }

            _itemDataStateFlow.emit(result)
        }
    }
}