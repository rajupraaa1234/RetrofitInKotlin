package com.example.retrofitinkotlin.ApiServices

import com.example.retrofitinkotlin.ApiConstant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppRetrofit {

    private var apiServices: ApiServices
    init{
        apiServices = ProvideServices()
    }

   companion object {
       private lateinit var intstanse: AppRetrofit

       fun getIntstanse(): AppRetrofit {
           initInstance()
           return intstanse
       }

       private fun initInstance() {
           if (intstanse == null) {
               // Create the instance
               intstanse =AppRetrofit()
           }
       }
   }

    fun getServices(): ApiServices {
        return apiServices
    }

    private fun ProvideServices(): ApiServices {


//            val retrofit = Retrofit.Builder()
//                .baseUrl(ApiConstant.Baseurl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//            return retrofit.create(ApiServices::class.java)

       // return retrofitService!!
//         To show the Api Request & Params
        return try {
            Retrofit.Builder()
                .baseUrl(ApiConstant.Baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiServices::class.java)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}