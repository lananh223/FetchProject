package com.example.fetchproject.network

import com.example.fetchproject.model.ItemData
import retrofit2.http.GET

interface ItemService {
    @GET("/hiring.json")

    suspend fun fetchData(): List<ItemData>
}