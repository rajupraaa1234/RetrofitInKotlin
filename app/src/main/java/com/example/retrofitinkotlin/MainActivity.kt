package com.example.retrofitinkotlin

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitinkotlin.Adapter.RecyclerViewAdapter
import com.example.retrofitinkotlin.ApiServices.ApiServices
import com.example.retrofitinkotlin.ApiServices.ApiServices.Companion.retrofitService
import com.example.retrofitinkotlin.ApiServices.MainRepository
import com.example.retrofitinkotlin.ApiServices.MainViewModel
import com.example.retrofitinkotlin.ApiServices.MyViewModelFactory
import com.example.retrofitinkotlin.ViewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var viewmodel: UserViewModel
    private val TAG = "MainActivity"
    private val retrofitService = ApiServices.getInstance()
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        //FetchDataFromServer()
        FetchDataFromServerInOtherWay()
       // getCall()
    }

    private fun FetchDataFromServerInOtherWay() {



        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            val recyclerViewAdapter = RecyclerViewAdapter(this, it.toTypedArray())
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = recyclerViewAdapter
        })

        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllMovies()
    }

    private fun init() {
        recyclerView = findViewById<RecyclerView>(R.id.retrofituserlist)

        viewmodel = ViewModelProvider(this).get(UserViewModel::class.java)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)
    }

    private fun FetchDataFromServer(){
        viewmodel.getUser().observe(this, Observer {
            val recyclerViewAdapter = RecyclerViewAdapter(this, it.toTypedArray())
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = recyclerViewAdapter
        })
    }

    private fun handleResponse(response: List<User1>?){
        Log.i("MyData",response.toString())
        val use : Array<User1>? = response?.toTypedArray()
        Log.i("MyLength"," "+use?.size)
    }



























//    fun getCall() {
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl(ApiConstant.Baseurl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val retrofitInterface: ApiServices = retrofit.create(ApiServices::class.java)
//        // Call<List<User1>> call=retrofitInterface.getUser();
//        val map = HashMap<String, String>()
//        map["userId"] = "1"
//        map["_sort"] = "id"
//        map["_order"] = "desc"
//        val call: Call<List<User1?>?>? = retrofitInterface.getUser()
//        //Call<List<User1>> call=retrofitInterface.getUsers(5,2);
//        //Call<List<User1>> call=retrofitInterface.getUser(1);
//            call?.enqueue(object : Callback<List<User1?>?> {
//                override fun onResponse(call: Call<List<User1?>?>,response: Response<List<User1?>?>) {
//                    val res = response.body()!!
//                    var use: Array<User1?>? = arrayOfNulls(response.raw().)
//                    Log.i("MyLength"," "+use)
//                   // val recyclerViewAdapter = RecyclerViewAdapter(this@MainActivity, use)
//                   // recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
//                    //recyclerView.adapter = recyclerViewAdapter
//                }
//                override fun onFailure(call: Call<List<User1?>?>, t: Throwable) {
//                   Log.i("MainActivity"," " + "Failed")
//                   // Toast.makeText(this, "Failed...", Toast.LENGTH_SHORT).show()
//                }
//            })
////            call.enqueue(object : Callback<List<User1?>> {
////                override fun onResponse(call: Call<List<User1?>>, response: Response<List<User1?>>) {
////                    val res = response.body()!!
////                    var use: Array<User1?>? = arrayOfNulls(res.size)
////                    use = res.toTypedArray(use)
////                    val recyclerViewAdapter = RecyclerViewAdapter(this, use)
////                    recyclerView.layoutManager = LinearLayoutManager(this)
////                    recyclerView.adapter = recyclerViewAdapter
////                }
////
////                override fun onFailure(call: Call<List<User1?>>, t: Throwable) {
////                    Toast.makeText(this, "Failed...", Toast.LENGTH_SHORT).show()
////                }
////            })
//    }
}



