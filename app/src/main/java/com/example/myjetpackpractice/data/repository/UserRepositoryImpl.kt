package com.example.myjetpackpractice.data.repository

import com.example.myjetpackpractice.data.UserData
import com.example.myjetpackpractice.data.dao.UserDao
import javax.inject.Inject
import javax.inject.Singleton


class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) {
    suspend fun saveUser(userData: UserData) {
        userDao.saveUser(userData)
    }
}