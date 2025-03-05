package com.example.myjetpackpractice.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myjetpackpractice.R
import com.example.myjetpackpractice.data.UserData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loginPage(navController: NavController,loginViewModel: LoginViewModel = hiltViewModel()) {
    var userName by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var checked by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.login_page_bg),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "UserIcon",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
            )

            Text(
                text = "Login",
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 20.dp)
            )

            TextField(value = userName, onValueChange = { userName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White, // Background color
                    focusedIndicatorColor = Color.Transparent, // Hide underline when focused
                    unfocusedIndicatorColor = Color.Transparent, // Hide underline when unfocused
                    disabledIndicatorColor = Color.Transparent // Hide underline when disabled
                ),
                shape = RoundedCornerShape(25.dp),
                leadingIcon = {
                    Row(
                        modifier = Modifier.padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Person Icon
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "User Icon",
                            tint = Color.Gray,
                            modifier = Modifier.height(50.dp)
                        )

                        // Spacer between icon and separator
                        Spacer(modifier = Modifier.width(8.dp))

//                         Separator Image
                        Image(
                            painter = painterResource(id = R.drawable.seprator), // Replace with your separator drawable
                            contentDescription = "Separator",
                            modifier = Modifier
                                .height(50.dp)
                        )

//                         Spacer between separator and text field
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                TextField(value = password, onValueChange = { password = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp),
                    shape = RoundedCornerShape(25.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White, // Background color
                        focusedIndicatorColor = Color.Transparent, // Hide underline when focused
                        unfocusedIndicatorColor = Color.Transparent, // Hide underline when unfocused
                        disabledIndicatorColor = Color.Transparent // Hide underline when disabled
                    ),
                    leadingIcon = {
                        Row(
                            modifier = Modifier.padding(start = 8.dp),

                            ) {
                            // Person Icon
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "User Icon",
                                tint = Color.Gray
                            )

                            // Spacer between icon and separator
                            Spacer(modifier = Modifier.width(8.dp))

//                         Separator Image
                            Image(
                                painter = painterResource(id = R.drawable.seprator), // Replace with your separator drawable
                                contentDescription = "Separator",

                                )

//                         Spacer between separator and text field
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    }
                )
            }


            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { checked = !checked }
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Color.White,
                        checkedColor = Color.White,
                        checkmarkColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = stringResource(id = R.string.rememberMeText), color = Color.White)
            }


            Button(
                onClick = {
                    loginViewModel.saveUser(userName, password, checked)
                    userName = ""
                    password = ""
                    checked = false

                    navController.navigate("homePage")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(25.dp))
                    .padding(top = 25.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF6200EE), Color(0xFFFF5722)
                            )
                        )
                    ),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            ) {
                Text(text = stringResource(id = R.string.loginText), fontWeight = FontWeight.Bold)

            }

            Text(text = stringResource(id = R.string.forgotPassText),
                color = Color.White,
                modifier = Modifier
                    .clickable {

                    }
                    .padding(top = 20.dp))


        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp),
            contentAlignment = Alignment.BottomCenter // Align content to the bottom center

        ) {
            Text(
                text =
                buildAnnotatedString {
                    append(stringResource(id = R.string.NotAccountText))
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(stringResource(id = R.string.SignUpText))
                    }
                }, color = Color.White
            )
        }
    }


}
