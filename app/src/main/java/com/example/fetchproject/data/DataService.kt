package com.example.fetchproject.data

import retrofit2.Call
import retrofit2.http.GET

interface DataService {
    @GET("/hiring.json")
    fun getItemData(): Call<List<ItemData>>
}