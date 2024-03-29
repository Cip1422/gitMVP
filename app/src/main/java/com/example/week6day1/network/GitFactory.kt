package com.example.week6day1.network


import android.util.Log
import com.example.week6day1.model.Repositories
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitFactory {

    private val BASE_URL = "https://api.github.com/"

    private  var gitService: GitService

    init {
        gitService = createService(getRetrofitInstance())
    }

    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun createService(retrofit: Retrofit):GitService{
        return retrofit.create(GitService::class.java)
    }


    fun getRepsotories(): Call<List<Repositories>> {

        return gitService.getUser("Cip1422", "repos")



    }

}