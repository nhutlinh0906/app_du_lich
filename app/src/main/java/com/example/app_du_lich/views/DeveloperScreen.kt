package com.example.app_du_lich.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeveloperScreen(navController: NavController) {

    val posts = remember {
        mutableStateListOf(
            mapOf(
                "username" to "LQGB",
                "time" to "20:41",
                "placeName" to "Núi Hạ Long",
                "imageResId" to R.drawable.culture
            ),
            mapOf(
                "username" to "LQGB",
                "time" to "20:41",
                "placeName" to "Núi Hạ Long",
                "imageResId" to R.drawable.culture
            ),
            mapOf(
                "username" to "LQGB",
                "time" to "20:41",
                "placeName" to "Núi Hạ Long",
                "imageResId" to R.drawable.culture
            ), mapOf(
                "username" to "LQGB",
                "time" to "20:41",
                "placeName" to "Núi Hạ Long",
                "imageResId" to R.drawable.culture
            )
        )
    }

    val pinkBackground = Color(0xFFFF69B4)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("HomeScreen") }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Quay lại"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().background(pinkBackground)) {
            Column(modifier = Modifier.fillMaxSize()) {

                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                ) {
                    items(posts) { post ->
                        LocationPostItem(post)
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }

            // thêm nút add
            FloatingActionButton(
                onClick = { navController.navigate("EditDeveloperInformationScreen") },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                containerColor = Color.White
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.Blue,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }

}

// ==== SINGLE POST ITEM ====
@Composable
fun LocationPostItem(post: Map<String, Any>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            // ==== USER INFO ====
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        post["username"] as String,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(post["time"] as String, fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    post["placeName"] as String,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ==== IMAGE ====
            Image(
                painter = painterResource(id = post["imageResId"] as Int),
                contentDescription = post["placeName"] as String,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ==== ACTION ICONS ====
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = Color.Gray)
                }
                IconButton(onClick = { //navController.navigate("PersonalInfoScreen")
                }) {
                    Icon(Icons.Default.ChatBubbleOutline,
                        contentDescription = "Comment",
                        tint = Color.Gray)
                }
                IconButton(onClick = {//navController.navigate("LocationDetailsScreen")
                }) {
                    Icon(Icons.Default.Info,
                        contentDescription = "Info",
                        tint = Color.Gray)
                }
            }
        }
    }
}
