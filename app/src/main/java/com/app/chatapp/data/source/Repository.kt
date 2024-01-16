package com.app.chatapp.data.source

import android.content.Context
import com.app.chatapp.data.network.response.Model
import com.app.chatapp.data.source.interf.AppDataSource
import com.app.chatapp.data.source.interf.DbSource
import com.app.chatapp.data.source.local.LocalDataSource
import com.app.chatapp.data.source.remote.RemoteDataSource
import retrofit2.Call

class Repository : AppDataSource, DbSource {
    private val localDataSource = LocalDataSource()
    private val remoteDataSource = RemoteDataSource()

    override fun login(email: String, password: String): Call<Model> {
        return remoteDataSource.login(email, password)
    }

//    override fun getListUser(context: Context): List<Model> {
//        return localDataSource.getListUser(context)
//    }
}