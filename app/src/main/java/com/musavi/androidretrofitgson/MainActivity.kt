package com.musavi.androidretrofitgson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.musavi.androidretrofitgson.helper.MyRetrofit
import com.musavi.androidretrofitgson.model.MyModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textMain = findViewById<TextView>(R.id.text_main)

        val myServe = MyRetrofit.create()

        myServe.getposts().enqueue(object : Callback<List<MyModel>>{
            override fun onFailure(call: Call<List<MyModel>>, t: Throwable) {
                Log.e("Error", "Ada Error ini gan : ${t.message}")
            }

            override fun onResponse(call: Call<List<MyModel>>, response: Response<List<MyModel>>) {
                if(response.isSuccessful){
                    val data = response.body()
                    val builder = StringBuilder()

                    data?.map {
                        builder.append(it.body)
                    }
                    textMain.setText(builder.toString())

                }
            }
        })
    }
}
