package com.app.chatapp.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.chatapp.data.network.response.Model
import com.app.chatapp.util.AppConstants

//@Database(entities = [Model::class], version = AppConstants.DATABASE_VERSION_1)
//abstract class LocalDatabase : RoomDatabase() {
//    abstract fun localDao(): LocalDao
//
//    companion object {
//        private var INSTANCE: LocalDatabase? = null
//        fun getInstance(context: Context): LocalDatabase {
//            if (INSTANCE == null) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    LocalDatabase::class.java,
//                    AppConstants.DATABASE_NAME
//                ).fallbackToDestructiveMigration().build()
//                INSTANCE = instance
//            }
//            return INSTANCE as LocalDatabase
//        }
//    }
//}