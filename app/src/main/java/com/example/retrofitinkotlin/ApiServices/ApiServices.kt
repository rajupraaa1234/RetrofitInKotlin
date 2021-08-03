package com.example.retrofitinkotlin.ApiServices

import com.example.retrofitinkotlin.ApiConstant
import com.example.retrofitinkotlin.User1
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServices {
    @GET("posts")
    fun getUser(): Call<List<User1>>


    @GET("posts")
    fun getAllUser() : Call<List<User1>>

    companion object {

        var retrofitService: ApiServices? = null

        fun getInstance() : ApiServices {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(ApiConstant.Baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ApiServices::class.java)
            }
            return retrofitService!!
        }
    }
}