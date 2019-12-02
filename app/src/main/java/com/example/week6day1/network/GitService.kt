package com.example.week6day1.network


import com.example.week6day1.model.Repositories
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitService {


    @GET  ("users/{username}/{dataRequest}")

    fun getUser(@Path("username") userName: String, @Path("dataRequest")dateRequest: String):
            Call<List<Repositories>>
}