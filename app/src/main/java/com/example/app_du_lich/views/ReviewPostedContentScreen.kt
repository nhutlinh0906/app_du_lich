package com.example.datn.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewPostedContentScreen(navController: NavController) {
    val pinkBackground = Color(0xFFFF69B4)
    val creamColor = Color(0xFFFFF8DC)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(pinkBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp) // dành không gian cho BottomNavigationBar
        ) {
            // Top Bar with Back Button
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = pinkBackground
                )
            )

            // Content Elements Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                StarContentElement()
                ImageContentElement()
                CircleContentElement()
            }

            // Content Bars Section
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(6) {
                    ContentBar()
                }
            }
        }

        // Bottom Navigation Bar đặt ở đáy màn hình
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            BottomNavigationBar()
        }
    }
}

@Composable
fun StarContentElement() {
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star",
                tint = Color(0xFFFFD700),
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = "content",
                fontSize = 10.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ImageContentElement() {
    val creamColor = Color(0xFFFFF8DC)

    Box(
        modifier = Modifier
            .size(80.dp)
            .background(creamColor, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "hình ảnh",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CircleContentElement() {
    val creamColor = Color(0xFFFFF8DC)

    Box(
        modifier = Modifier
            .size(80.dp)
            .background(creamColor, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "content",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContentBar() {
    val creamColor = Color(0xFFFFF8DC)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(creamColor, RoundedCornerShape(8.dp))
    )


    @Composable
    fun BottomNavigationBar() {
        NavigationBar(
            containerColor = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            NavigationBarItem(
                icon = {
                    Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black)
                },
                selected = false,
                onClick = { /* Handle home click */ }
            )

            NavigationBarItem(
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            "hot",
                            color = Color.Red,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "place",
                            color = Color.Red,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                selected = false,
                onClick = { /* Handle hot place click */ }
            )

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color.Black
                    )
                },
                selected = false,
                onClick = { /* Handle profile click */ }
            )

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Color.Black
                    )
                },
                selected = false,
                onClick = { /* Handle settings click */ }
            )
        }
    }
}
