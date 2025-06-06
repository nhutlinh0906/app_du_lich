package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.example.app_du_lich.R
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavController
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var content by remember { mutableStateOf("") }
    val pinkColor = Color(0xFFFF69B4)
    val selectedTab = remember { mutableStateOf("home") }
    var fabPosition by remember { mutableStateOf(Offset(0f, 0f)) }
    var isDragging by remember { mutableStateOf(false) }

    val dummyDestinations = List(10) { index -> "Địa điểm #${index + 1}" }

    Scaffold(
        bottomBar = {
            com.example.app_du_lich.components.BottomNavigationBar(
                navController = navController,
                selectedTab = selectedTab.value,
                onTabSelected = { selectedTab.value = it }
            )
        },
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .offset { IntOffset(fabPosition.x.roundToInt(), fabPosition.y.roundToInt()) }
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragStart = { isDragging = true },
                            onDragEnd = { isDragging = false },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                fabPosition += dragAmount
                            }
                        )
                    }
            ) {
                FloatingActionButton(
                    onClick = { /* Handle FAB click */ },
                    containerColor = pinkColor,
                    contentColor = Color.White,
                    shape = CircleShape,
                    modifier = Modifier.size(56.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.default_profile),
                        contentDescription = "Chat",
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baner),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(pinkColor)
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = content,
                        onValueChange = { content = it },
                        placeholder = { Text("Tìm kiếm") },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 12.dp),
                        shape = RoundedCornerShape(24.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White
                        ),
                        textStyle = LocalTextStyle.current.copy(fontSize = 13.sp),
                        leadingIcon = {
                            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Gray)
                        },
                        trailingIcon = {
                            Icon(
                                Icons.Default.Mic,
                                contentDescription = "Microphone",
                                tint = Color.Gray,
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable {
                                         navController.navigate("VoiceScreen")
                                    }
                            )
                        }
                    )

                    Box(
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .clickable { navController.navigate("NotificationScreen") }
                    ) {
                        Icon(Icons.Default.Notifications,
                            contentDescription = "Notifications",
                            tint = Color.Black)
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(Color.Red, CircleShape)
                                .offset(x = 12.dp, y = (-4).dp)
                        )
                    }

                    Box(modifier = Modifier.padding(start = 12.dp)) {
                        IconButton(
                            onClick = {  },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(Icons.Default.FilterList,
                                contentDescription = "Filter",
                                tint = Color.Black)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CircularIconButton(
                       icon =  Icons.Default.Favorite,
                       backgroundColor =  Color(0xffA0EAEA),
                       iconColor =  Color.Red,
                        onClick = {navController.navigate("FavouriteScreen")},
                        modifier = Modifier
                    )
                    CircularIconButton(
                        Icons.Default.RestaurantMenu,
                        Color(0xffA0EAEA),
                        Color.Black,
                        onClick = {  navController.navigate("TourHistoryDetails")},
                        modifier = Modifier

                    )
                    CircularIconButton(
                        Icons.Default.FormatListNumberedRtl,
                        Color(0xffA0EAEA),
                        Color.Gray,
                        onClick = {  navController.navigate("PersonalScheduleScreen")},
                        modifier = Modifier

                    )
                    CircularIconButton(
                        Icons.Default.SettingsBackupRestore,
                        Color(0xffA0EAEA),
                        Color.White,
                        onClick = {  navController.navigate("TourHistoryDetails")},
                        modifier = Modifier

                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(dummyDestinations) { destination ->
                        DestinationCard(
                            title = destination,
                            subtitle = "Thông tin mô tả...",
                            onClick = {
                                navController.navigate("LocationDetailsScreen")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CircularIconButton(
    icon: ImageVector,
    backgroundColor: Color,
    iconColor: Color,
    onClick: () -> Unit,
    modifier : Modifier
) {
    Box(
        modifier = modifier
            .size(50.dp)
            .background(backgroundColor, CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(icon, contentDescription = null, tint = iconColor, modifier = Modifier.size(24.dp))
    }
}

@Composable
fun DestinationCard(
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF87CEEB))
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 12.sp
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.3f), RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                    .padding(8.dp)
                    .align(Alignment.BottomStart)
            ) {
                Text(text = subtitle, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            }
        }
    }
}


