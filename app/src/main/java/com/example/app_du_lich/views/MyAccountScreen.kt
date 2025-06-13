package com.example.app_du_lich.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_du_lich.viewmodels.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAccountScreen(navController: NavController, viewModel: UserViewModel) {
    val pinkColor = Color(0xFFFF69B4)
    val scrollState = rememberScrollState()

    // Không cần viewModel() nữa vì đã nhận từ NavGraph
    LaunchedEffect(Unit) {
        viewModel.fetchUserById(1) // Giữ nguyên, nhưng bạn có thể thay 1 bằng userId động
    }

    val user = viewModel.user
    val errorMessage = viewModel.errorMessage
    val fullName = user?.nameUser ?: "Chưa có dữ liệu"
    val gender = user?.genderUser ?: "Chưa có dữ liệu"
    val phone = user?.phoneUser ?: "Chưa có dữ liệu"
    val email = user?.emailUser ?: "Chưa có dữ liệu"
    val address = user?.addressUser ?: "Chưa có dữ liệu"
    val userId = user?.idUser ?: 1 // Lấy userId từ user, mặc định là 1 nếu chưa có

    Log.d("MyAccountScreen", "User: $user, Error: $errorMessage")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Tài khoản của tôi",
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("HomeScreen") }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    TextButton(onClick = {
                        if (userId != 0) {
                            navController.navigate("PersonalInfoScreen/$userId")
                        } else {
                            Log.e("MyAccountScreen", "User ID không hợp lệ")
                        }
                    }) {
                        Text(
                            text = "Sửa",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = pinkColor
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column {
                    InfoRow(label = "Họ và tên", value = fullName)
                    InfoRow(label = "Giới tính", value = gender)
                    InfoRow(label = "Số điện thoại", value = phone)
                    InfoRow(label = "Email", value = email)
                    InfoRow(label = "Địa chỉ", value = address)
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(1.dp, Color.LightGray.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, fontSize = 16.sp, color = Color(0xFF333333))
        Text(value, fontSize = 16.sp, color = Color(0xFF333333), fontWeight = FontWeight.Medium)
    }
}

@Composable
fun AccountOptionItem(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFFFF69B4),
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Arrow",
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
    }
}