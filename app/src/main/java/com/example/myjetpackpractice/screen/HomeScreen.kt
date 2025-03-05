package com.example.myjetpackpractice.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun homePage(navController: NavController,loginViewModel: LoginViewModel = hiltViewModel() ){
    val userData =loginViewModel.getUserData()
    val userDataValue = loginViewModel.UserLiveData.value
    val userName = userDataValue?.userName?:""
    Text(text =userName , modifier = Modifier.fillMaxWidth())
}