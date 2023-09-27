package com.example.fetchproject.model

import retrofit2.http.GET

interface DataService {
    @GET("/hiring.json")
    suspend fun getItemData(): List<ItemData>
}