package com.example.myjetpackpractice.data.database

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myjetpackpractice.data.UserData
import com.example.myjetpackpractice.data.dao.UserDao

@Database(entities = [UserData::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    }
