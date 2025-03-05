package com.example.myjetpackpractice.module

import android.content.Context
import androidx.room.Room
import com.example.myjetpackpractice.data.dao.UserDao
import com.example.myjetpackpractice.data.database.MyDatabase
import com.example.myjetpackpractice.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UserDataModule {


    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context):MyDatabase{
        return Room.databaseBuilder(context,MyDatabase::class.java,"MyDatabase").build()
    }

    @Provides
    fun getUserDao(myDatabase: MyDatabase):UserDao{
        return myDatabase.userDao()
    }

}
