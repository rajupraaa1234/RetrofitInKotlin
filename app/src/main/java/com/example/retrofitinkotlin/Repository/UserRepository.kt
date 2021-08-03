package com.example.retrofitinkotlin.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitinkotlin.ApiServices.AppRetrofit
import com.example.retrofitinkotlin.User1
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun getUser(): LiveData<List<User1>> {
        val data = MutableLiveData<List<User1>>()
        AppRetrofit.getIntstanse().getServices().getUser()
            ?.enqueue(object : Callback<List<User1>> {
                override fun onResponse(call: Call<List<User1>>,response: Response<List<User1>>) {
                    data?.postValue(response.body() as List<User1>?)
                }

                override fun onFailure(call: Call<List<User1>>, t: Throwable) {
                    data?.postValue(null)
                }
            })
        return data
    }
}