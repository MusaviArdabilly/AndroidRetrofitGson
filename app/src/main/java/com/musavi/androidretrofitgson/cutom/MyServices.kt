package com.musavi.androidretrofitgson.cutom

import com.musavi.androidretrofitgson.model.MyModel
import retrofit2.Call
import retrofit2.http.GET

interface MyServices {
    @GET("posts")
    fun getposts(): Call<List<MyModel>>
}