package com.example.itineraryapp
/*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItineraryDetailsScreen() {
    val pinkColor = Color(0xFFFF69B4)
    var itineraryName by remember { mutableStateOf("") }
    val locations = remember { mutableStateListOf("", "", "", "", "") }
    val times = remember { mutableStateListOf("", "", "", "", "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(pinkColor)
    ) {
        // Top Bar with back button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* Handle back navigation */ }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        // Scrollable content
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            // Itinerary Name Field
            OutlinedTextField(
                value = itineraryName,
                onValueChange = { itineraryName = it },
                placeholder = { Text("tên lịch trình") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor =  Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                textStyle = androidx.compose.ui.text.TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Location and Time Input Rows with Menu
            repeat(5) { index ->
                LocationTimeRowWithMenu(
                    locationNumber = index + 1,
                    location = locations[index],
                    onLocationChange = { locations[index] = it },
                    time = times[index],
                    onTimeChange = { times[index] = it },
                    onMenuClick = { /* Handle menu click for row ${index + 1} */ }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Save Button
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { /* Handle save */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    shape = CircleShape,
                    modifier = Modifier
                        .size(100.dp)
                ) {
                    Text(
                        text = "Lưu",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }


        BottomNavigationBar()

        // Personal Itinerary Details Text
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "chi tiết lịch trình cá nhân(Bảo)",
                fontSize = 14.sp,
                color = Color.Black
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationTimeRowWithMenu(
    locationNumber: Int,
    location: String,
    onLocationChange: (String) -> Unit,
    time: String,
    onTimeChange: (String) -> Unit,
    onMenuClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Location Field
        OutlinedTextField(
            value = location,
            onValueChange = onLocationChange,
            placeholder = { Text("địa điểm $locationNumber") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor =  Color.White,
                unfocusedContainerColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1.5f)
                .height(50.dp),
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 14.sp
            ),
            singleLine = true
        )

        // Time Field
        OutlinedTextField(
            value = time,
            onValueChange = onTimeChange,
            placeholder = { Text("thời gian") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .height(50.dp),
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 14.sp
            ),
            singleLine = true
        )

        // Menu Icon
        IconButton(
            onClick = onMenuClick,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Menu",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier.height(80.dp)
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = Color.Black
                )
            },
            selected = false,
            onClick = { /* Handle home click */ }
        )

        NavigationBarItem(
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "hot",
                        color = Color.Red,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "place",
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

@Preview(showBackground = true)
@Composable
fun ItineraryDetailsScreenPreview() {
    MaterialTheme {
        ItineraryDetailsScreen()
    }
}

*/