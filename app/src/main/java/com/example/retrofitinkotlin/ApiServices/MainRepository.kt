package com.example.retrofitinkotlin.ApiServices

class MainRepository constructor(private val retrofitService: ApiServices) {

    fun getAllMovies() = retrofitService.getAllUser()
}