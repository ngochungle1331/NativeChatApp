package com.app.chatapp.data.source.interf

import com.app.chatapp.data.network.response.Model
import retrofit2.Call

interface AppDataSource {
    fun login(email: String, password: String) : Call<Model>
}