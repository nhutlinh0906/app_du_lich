package com.example.datn.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_du_lich.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(navController: NavController) {
    val pinkColor = Color(0xFFFF69B4)
    val selectedTab = null

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Bộ lọc tìm kiếm nâng cao",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("HomeScreen") }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black,
                            modifier = Modifier.size(28.dp)
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
                .padding(paddingValues)
                .background(pinkColor)
                .padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            FilterItemWithDropdown(
                imageResId = R.drawable.ic_location_type,
                label = "Loại địa điểm",
                initialValue = "Tất cả",
                options = listOf("Tất cả", "Nhà hàng", "Quán cà phê", "Khách sạn", "Du lịch")
            )

            FilterItemWithDropdown(
                imageResId = R.drawable.ic_location_red,
                label = "Vị trí",
                initialValue = "Tất cả",
                options = listOf("Tất cả", "Gần đây", "Quận 1", "Quận 2", "Quận 3")
            )

            FilterItemWithDropdown(
                imageResId = R.drawable.ic_rating,
                label = "Đánh giá",
                initialValue = "Tất cả",
                options = listOf("Tất cả", "5 sao", "4 sao trở lên", "3 sao trở lên")
            )

            FilterItemWithDropdown(
                imageResId = R.drawable.ic_price,
                label = "Mức giá",
                initialValue = "Bất kì",
                options = listOf("Bất kì", "Rẻ", "Trung bình", "Cao cấp")
            )

            FilterItemWithDropdown(
                imageResId = R.drawable.ic_time,
                label = "Giờ mở cửa",
                initialValue = "Bất kì",
                options = listOf("Bất kì", "Đang mở cửa", "Mở cả ngày", "Mở cuối tuần")
            )

            Spacer(modifier = Modifier.weight(1f))


        }
    }
}

@Composable
fun FilterItemWithDropdown(
    imageResId: Int,
    label: String,
    initialValue: String,
    options: List<String>
) {
    var selectedOption by remember { mutableStateOf(initialValue) }
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(28.dp)
                .padding(end = 4.dp)
        )

        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 12.dp, end = 16.dp)
                .weight(1f)
        )

        Box(
            modifier = Modifier
                .weight(1.5f)
                .clickable { expanded = true }  // Đặt clickable lên Box bên ngoài để xử lý click
        ) {
            OutlinedTextField(
                value = selectedOption,
                onValueChange = { },
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Dropdown",
                        modifier = Modifier.size(28.dp)
                    )
                },
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                ),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(Color.White)
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = option,
                                fontSize = 16.sp,
                                fontWeight = if (option == selectedOption) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        onClick = {
                            selectedOption = option
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}
