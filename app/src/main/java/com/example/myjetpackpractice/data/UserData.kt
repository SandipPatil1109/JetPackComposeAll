package com.example.myjetpackpractice.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserData(@PrimaryKey(autoGenerate = true) val id: Int = 0, val userName: String, val password: String,val checkedState:Boolean)
