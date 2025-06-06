package com.example.datn.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_du_lich.R

@Composable
fun SuggestionsScreen(navController: NavController) {
    val pinkColor = Color(0xFFFF69B4)
    val blueColor = Color(0xFF1E90FF)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(pinkColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp) // Padding chỉ áp dụng cho phần nội dung chính
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Handle back */ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = "Gợi ý theo sở thích",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Khung nội dung chính
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .border(2.dp, blueColor, RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CategoryItem(R.drawable.beach, "Bãi biển")
                        CategoryItem(R.drawable.culture, "Văn hóa")
                        CategoryItem(R.drawable.culture, "Văn hóa")
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CategoryItem(R.drawable.nature, "Thiên nhiên")
                        CategoryItem(R.drawable.food, "Ẩm thực")
                        CategoryItem(R.drawable.food, "Ẩm thực")
                    }
                }
            }

            Spacer(modifier = Modifier.height(80.dp)) // Chừa chỗ cho thanh điều hướng
        }

        // Bottom Navigation Bar nằm cố định dưới cùng, tràn viền
        BottomNavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun CategoryItem(imageResId: Int, categoryName: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = categoryName,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5f)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = categoryName,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = Color.White,
        modifier = modifier
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
                    Text("hot", color = Color.Red, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    Text("place", color = Color.Red, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            },
            selected = false,
            onClick = { /* Handle hot place click */ }
        )
        NavigationBarItem(
            icon = {
                Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.Black)
            },
            selected = false,
            onClick = { /* Handle profile click */ }
        )
        NavigationBarItem(
            icon = {
                Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color.Black)
            },
            selected = false,
            onClick = { /* Handle settings click */ }
        )
    }
}
