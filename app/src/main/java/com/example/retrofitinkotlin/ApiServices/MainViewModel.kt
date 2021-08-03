package com.example.retrofitinkotlin.ApiServices

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitinkotlin.User1
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<User1>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {

        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<User1>> {
            override fun onResponse(call: Call<List<User1>>, response: Response<List<User1>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User1>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}