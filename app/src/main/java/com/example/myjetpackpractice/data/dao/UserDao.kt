package com.example.myjetpackpractice.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myjetpackpractice.data.UserData
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(userData: UserData)

    @Query("select * from UserData ORDER BY id DESC LIMIT 1")
    suspend fun getUserData():UserData
}