package com.app.chatapp.data.source.remote

import com.app.chatapp.data.network.ApiService
import com.app.chatapp.data.network.response.Model
import com.app.chatapp.data.source.interf.AppDataSource
import retrofit2.Call

class RemoteDataSource : AppDataSource {
    private val apiService = ApiService
    override fun login(email: String, password: String): Call<Model> {
        return apiService.api.login(email, password)
    }
}