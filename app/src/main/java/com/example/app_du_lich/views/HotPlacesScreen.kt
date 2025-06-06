package com.example.datn.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
fun HotPlacesScreen(navController: NavController) {
    val pinkColor = Color(0xFFFF69B4)
    val selectedTab = remember { mutableStateOf("home") }


    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                selectedTab = selectedTab.value,
                onTabSelected = { selectedTab.value = it }
            )
        }
    ) { paddingValues ->
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(pinkColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp) // Chừa khoảng cho BottomNavigationBar
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Header với nút back
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /* Xử lý khi nhấn nút quay lại */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = "Địa điểm hot",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nội dung chính
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
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
                        PlaceItem(
                            imageResId = R.drawable.vung_tau,
                            placeName = "Vũng Tàu"
                        )
                        PlaceItem(
                            imageResId = R.drawable.nui_ba_den,
                            placeName = "Núi bà đen"
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        PlaceItem(
                            imageResId = R.drawable.da_lat,
                            placeName = "Đà Lạt"
                        )
                        PlaceItem(
                            imageResId = R.drawable.ha_tien,
                            placeName = "Hà Tiên"
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nút Đề xuất thêm
            Button(
                onClick = { /* Xử lý khi nhấn nút đề xuất thêm */ },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Đề xuất thêm",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    }
}


@Composable
fun PlaceItem(imageResId: Int, placeName: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = placeName,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5f)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = placeName,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
        )
    }
}
