package com.example.fetchproject.network

import com.example.fetchproject.model.ItemData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

class ItemRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val itemService: ItemService = retrofit.create(ItemService::class.java)

    suspend fun fetchData(): List<ItemData> {
        val result = itemService.fetchData()
        return result.sortedWith(
            compareBy<ItemData> { it.listId }
                .thenBy { it.id }
                .thenBy { it.name }
        ).filter { !it.name.isNullOrBlank() }
    }
}