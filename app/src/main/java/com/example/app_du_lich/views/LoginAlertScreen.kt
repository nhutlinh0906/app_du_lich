package com.example.datn.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_du_lich.R

@Composable
fun LoginAlertScreen(navController: NavController) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Xử lý quay lại */ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(onClick = { /* Xử lý khi nhấn Home */ }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        tint = Color.Black
                    )
                }

                IconButton(onClick = { /* Xử lý khi nhấn Hot Place */ }) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "hot",
                            fontSize = 12.sp,
                            color = Color.Red
                        )
                        Text(
                            text = "place",
                            fontSize = 12.sp,
                            color = Color.Red
                        )
                    }
                }

                IconButton(onClick = { /* Xử lý khi nhấn Profile */ }) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color.Black
                    )
                }

                IconButton(onClick = { /* Xử lý khi nhấn Settings */ }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Color.Black
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Biểu tượng cảnh báo
            Image(
                painter = painterResource(id = R.drawable.ic_warning),
                contentDescription = "Warning",
                modifier = Modifier
                    .size(80.dp)
                    .padding(vertical = 16.dp)
            )

            // Tiêu đề cảnh báo
            Text(
                text = "Cảnh báo đăng nhập",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Mô tả cảnh báo
            Text(
                text = "Tài khoảng của bạn vừa đăng nhập trên một thiết bị mới",
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Thông tin thời gian
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = "Time",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Thời gian: 12/5/2025-9:49",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Thông tin vị trí
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "Location",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Vị trí: TP Hồ Chí Minh, Việt Nam",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Thông tin thiết bị
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_device),
                    contentDescription = "Device",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Thiết bị: iphone 14-Safari",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Nút "Đây là tôi"
            Button(
                onClick = { /* Xử lý khi nhấn Đây là tôi */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFF9C4) // Màu vàng nhạt
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Đây là tôi",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            // Nút "Không phải là tôi"
            Button(
                onClick = { /* Xử lý khi nhấn Không phải là tôi */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFF9C4) // Màu vàng nhạt
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Không phải là tôi",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

