package com.example.myjetpackpractice.screen

import androidx.lifecycle.ViewModel
import com.example.myjetpackpractice.data.UserData
import com.example.myjetpackpractice.data.repository.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor( val userRepositoryImpl: UserRepositoryImpl):ViewModel() {
    fun saveUser(userName:String,password:String,checked:Boolean){
        val userData = UserData(1,userName,password,checked)
        CoroutineScope(Dispatchers.IO).launch {
            userRepositoryImpl.saveUser(userData)
        }

    }
}