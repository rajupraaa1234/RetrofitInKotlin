package com.example.retrofitinkotlin.ViewModel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitinkotlin.ApiServices.MainRepository
import com.example.retrofitinkotlin.Repository.UserRepository
import com.example.retrofitinkotlin.User1

class UserViewModel() : ViewModel() {
    lateinit var repository : UserRepository

    init {
        repository = UserRepository()
    }

    fun getUser() : LiveData<List<User1>> {
        return repository.getUser()
    }
}