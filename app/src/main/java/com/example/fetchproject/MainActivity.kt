package com.example.fetchproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchproject.data.DataService
import com.example.fetchproject.data.ItemAdapter
import com.example.fetchproject.data.ItemData
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "MainActivity"
private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var itemDataList: List<ItemData>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set up retrofit to fetch data
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val dataService = retrofit.create(DataService::class.java)

        dataService.getItemData().enqueue(object : Callback<List<ItemData>> {
            override fun onResponse(
                call: Call<List<ItemData>>,
                response: Response<List<ItemData>>
            ) {
                itemDataList = response.body()

                if (itemDataList == null) {
                    Log.w(TAG, "Did not receive a valid response body")
                    return
                }

                recyclerView.adapter = ItemAdapter(itemDataList!!)
                    .apply {
                        notifyDataSetChanged()
                    }
            }

            override fun onFailure(call: Call<List<ItemData>>, t: Throwable) {
                Log.e(TAG, "onFailure $t")
            }
        })
    }
}