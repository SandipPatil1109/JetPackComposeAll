package com.example.myjetpackpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myjetpackpractice.screen.homePage
import com.example.myjetpackpractice.screen.loginPage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           appNavigation()
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun appNavigation(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination ="login"){
            composable("login"){ loginPage(navController = navController)}
            composable("homePage"){ homePage(navController = navController) }
        }
    }






}


