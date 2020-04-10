package com.musavi.androidretrofitgson.helper

import com.musavi.androidretrofitgson.cutom.MyServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofit {
    fun create() : MyServices{
        val retro = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
        return retro.create(MyServices::class.java)
    }
}