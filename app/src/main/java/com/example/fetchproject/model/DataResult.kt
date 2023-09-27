package com.example.fetchproject.model

sealed class DataResult {
    object Empty : DataResult()
    data class Success(val dataList: List<ItemData>) : DataResult()
    data class Error(val error: Throwable) : DataResult()
}
