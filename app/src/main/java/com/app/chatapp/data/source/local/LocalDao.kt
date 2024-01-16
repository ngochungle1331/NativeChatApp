package com.app.chatapp.data.source.local

import androidx.room.Dao
import androidx.room.Query
import com.app.chatapp.data.network.response.Model

//@Dao
interface LocalDao {
//    @Query("SELECT * FROM MODEL")
    fun getListUser() : List<Model>
}