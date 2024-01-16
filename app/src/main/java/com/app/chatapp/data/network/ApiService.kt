package com.app.chatapp.data.network

import com.app.chatapp.data.network.response.Model
import com.app.chatapp.util.AppConstants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST

interface ApiService {
    companion object {
        val api: ApiService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl(AppConstants.BASE_URL)
            .build()
            .create(ApiService::class.java)
    }

    @POST("auth/login")
    fun login(
        email: String, password: String
    ): Call<Model>

}