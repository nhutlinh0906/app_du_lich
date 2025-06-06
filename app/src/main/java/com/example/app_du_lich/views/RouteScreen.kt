package com.example.app_du_lich.views

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.app_du_lich.components.BottomNavigationBar


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class RoutePoint(
    val id: Int,
    val label: String,
    val isStartOrEnd: Boolean = false
)

@Composable
fun RouteScreen(navController: NavController) {
    val pinkBackground = Color(0xFFFF69B4)
    val greenCircle = Color(0xFF4CAF50)

    val routePoints = listOf(
        RoutePoint(1, "start", true),
        RoutePoint(2, "địa điểm\n1"),
        RoutePoint(3, "địa điểm\n2"),
        RoutePoint(4, "địa điểm\n3"),
        RoutePoint(5, "địa điểm\n4"),
        RoutePoint(6, "địa điểm\n5"),
        RoutePoint(7, "finish", true)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(pinkBackground)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Đẩy nút "start" xuống khỏi đỉnh màn hình
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }

            itemsIndexed(routePoints) { index, point ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Hình tròn cho điểm
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(greenCircle),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = point.label,
                            color = Color.Black,
                            fontSize = if (point.isStartOrEnd) 14.sp else 12.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            lineHeight = 14.sp
                        )
                    }

                    // Vẽ mũi tên đi xuống nếu chưa phải là điểm cuối
                    if (index < routePoints.size - 1) {
                        Canvas(
                            modifier = Modifier
                                .width(4.dp)
                                .height(40.dp)
                        ) {
                            val arrowSize = 8.dp.toPx()
                            val endY = size.height - 10.dp.toPx()
                            val centerX = size.width / 2

                            drawLine(
                                color = Color.Black,
                                start = Offset(centerX, 0f),
                                end = Offset(centerX, endY),
                                strokeWidth = 3.dp.toPx()
                            )

                            drawLine(
                                color = Color.Black,
                                start = Offset(centerX - arrowSize, endY - arrowSize),
                                end = Offset(centerX, endY),
                                strokeWidth = 3.dp.toPx()
                            )

                            drawLine(
                                color = Color.Black,
                                start = Offset(centerX + arrowSize, endY - arrowSize),
                                end = Offset(centerX, endY),
                                strokeWidth = 3.dp.toPx()
                            )
                        }
                    }
                }
            }
        }

        // Bottom Navigation Bar
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            val selectedTab = remember { mutableStateOf("home") }

            BottomNavigationBar(
                navController = navController,
                selectedTab = selectedTab.value,
                onTabSelected = { selectedTab.value = it }
            )
        }
    }


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
