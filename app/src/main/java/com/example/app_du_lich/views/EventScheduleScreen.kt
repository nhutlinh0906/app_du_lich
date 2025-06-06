package com.example.app_du_lich.views

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
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.app_du_lich.components.BottomNavigationBar

@Composable
fun EventScheduleScreen(navController: NavController) {
    val pinkColor = Color(0xFFFF69B4)
    val blueColor = Color(0xFF1E90FF)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .border(width = 2.dp, color = blueColor)
                .background(pinkColor)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Quay lại */ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = "Lịch sự kiện ",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nội dung trong Card trắng
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    EventItem(
                        imageResId = R.drawable.winter_festival,
                        date = "25 tháng 12",
                        location = "Địa điểm",
                        eventName = "Lễ hội mùa đông"
                    )

                    EventItem(
                        imageResId = R.drawable.music_festival,
                        date = "20 tháng 6",
                        location = "Địa điểm",
                        eventName = "Buổi hòa nhạc"
                    )

                    EventItem(
                        imageResId = R.drawable.art_exhibition,
                        date = "29 tháng 1",
                        location = "Địa điểm",
                        eventName = "Triển lãm nghệ thuật"
                    )

                    EventItem(
                        imageResId = R.drawable.sports_event,
                        date = "10 tháng 3",
                        location = "Sân vận động",
                        eventName = "Giải đấu thể thao"
                    )

                    EventItem(
                        imageResId = R.drawable.tech_conference,
                        date = "5 tháng 7",
                        location = "Trung tâm hội nghị",
                        eventName = "Hội thảo công nghệ"
                    )

                    EventItem(
                        imageResId = R.drawable.food_festival,
                        date = "15 tháng 9",
                        location = "Công viên trung tâm",
                        eventName = "Lễ hội ẩm thực"
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
     val selectedTab = remember { mutableStateOf("home") }

    BottomNavigationBar(
        navController = navController,
        selectedTab = selectedTab.value,
        onTabSelected = { selectedTab.value = it }
    )
}

@Composable
fun EventItem(imageResId: Int, date: String, location: String, eventName: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = eventName,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = date,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )

            Text(
                text = location,
                fontSize = 16.sp,
                color = Color.Black
            )

            Text(
                text = eventName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}

