package com.example.datn.ui.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_du_lich.components.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationDetailsScreen(navController: NavController) {
    val selectedTab = remember { mutableStateOf("home") }

    Scaffold(
        bottomBar = {
            val selectedTab = remember { mutableStateOf("home") }
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
                .padding(paddingValues)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFFE91E63), Color(0xFFAD1457))
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Card chính chứa thông tin địa điểm
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column {
                        // Phần hình ảnh
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(Color(0xFFFF9800), Color(0xFFFF5722))
                                        )
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Núi Bà Đen ",
                                    color = Color.White,
                                    fontSize = 16.sp
                                )
                            }
                        }

                        // Phần nội dung mô tả
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Núi Bà Đen",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    repeat(5) {
                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = "Star",
                                            tint = Color(0xFFFFC107),
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "Heart",
                                        tint = Color(0xFFE91E63),
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = "Núi Văn Sơn, núi Mót",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color.Black
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Núi Bà Đen gần Tây Ninh liên truyền thuyết về Lý Thiên Hương, một thiếu nữ xinh đẹp, trung hậu, vì tránh lánh kẻ xấu mà gia đình xuống núi. Sau khi mất, bà thường hiện linh giúp đỡ dân lành, được tôn làm \"Bà Đen\" và lập miếu thờ.",
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                color = Color.Gray,
                                textAlign = TextAlign.Justify
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Hàng các nút hành động
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ActionButton(
                        icon = Icons.Default.ChatBubbleOutline,
                        onClick = {  navController.navigate("EvaluateScreen")}
                    )

                    ActionButton(
                        icon = Icons.Default.AccessTime,
                        onClick = { /* TODO */ }
                    )

                    Box {
                        ActionButton(
                            icon = Icons.Default.Person,
                            onClick = { /* TODO */ }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun ActionButton(icon: ImageVector, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .background(Color.White.copy(alpha = 0.2f), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

