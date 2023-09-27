package com.example.fetchproject.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

class MainRepository {

    private val gsonConverterFactory: GsonConverterFactory = GsonConverterFactory.create()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .build()

    private val dataService = retrofit.create(DataService::class.java)

    suspend fun fetchData(): DataResult {
        return kotlin.runCatching {
            dataService.getItemData()
        }.fold(
            onSuccess = { dataList ->
                val sortedList = dataList.toSortedList()
                DataResult.Success(sortedList)
            },
            onFailure = { DataResult.Error(it) }
        )
    }

    private fun List<ItemData>.toSortedList(): List<ItemData> {
        return this.sortedWith(
            compareBy<ItemData> { it.listId }
                .thenBy { it.id }
                .thenBy { it.name }
        ).filter { it.name.isNullOrBlank() }
    }
}