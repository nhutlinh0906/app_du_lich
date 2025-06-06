package com.example.app_du_lich.views.DeveloperProductScreen.kt


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeveloperProductScreen(navController: NavController) {
    val pinkBackground = Color(0xFFFF69B4)
    val whiteBackground = Color.White

    var placeName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var contactInfo by remember { mutableStateOf("") }
    var openingTime by remember { mutableStateOf("") }
    var closingTime by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(pinkBackground)
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back Button
            IconButton(
                onClick = { /* Handle back navigation */ },
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            // Cube Icon
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, CircleShape)
                    .padding(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color.Black, RoundedCornerShape(4.dp))
                        .align(Alignment.Center)
                )
            }
        }

        // Form Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp, start = 16.dp, end = 16.dp, bottom = 90.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Image Field
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(whiteBackground, RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Hình ảnh",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                IconButton(onClick = { /* Handle camera action */ }) {
                    Icon(
                        imageVector = Icons.Default.Camera,
                        contentDescription = "Take Photo",
                        tint = Color.Black
                    )
                }
            }

            // Place Name Field
            TextField(
                value = placeName,
                onValueChange = { placeName = it },
                placeholder = { Text("Tên địa điểm") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(whiteBackground, RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            // Description Field
            TextField(
                value = description,
                onValueChange = { description = it },
                placeholder = { Text("Mô tả") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(whiteBackground, RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            // Address Field
            TextField(
                value = address,
                onValueChange = { address = it },
                placeholder = { Text("Địa chỉ") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(whiteBackground, RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            // Contact Info Field
            TextField(
                value = contactInfo,
                onValueChange = { contactInfo = it },
                placeholder = { Text("Thông tin liên lạc") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(whiteBackground, RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            // Opening Time Field
            TextField(
                value = openingTime,
                onValueChange = { openingTime = it },
                placeholder = { Text("Thời gian mở cửa") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(whiteBackground, RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            // Closing Time Field
            TextField(
                value = closingTime,
                onValueChange = { closingTime = it },
                placeholder = { Text("Thời gian đóng cửa") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(whiteBackground, RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        // Add Button
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
        ) {
            Button(
                onClick = { /* Handle add action */ },
                modifier = Modifier
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "Thêm",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

