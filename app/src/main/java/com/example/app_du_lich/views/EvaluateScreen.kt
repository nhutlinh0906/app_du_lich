package com.example.app_du_lich
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.io.InputStream

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EvaluateScreen(navController: NavController) {
    val pinkColor = Color(0xFFFF69B4)
    var commentText by remember { mutableStateOf("") }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var capturedBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var showImageSourceDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current

    // Launcher chọn ảnh từ thư viện
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            selectedImageUri = it
            capturedBitmap = null // Clear bitmap camera nếu có
        }
    }

    // Launcher chụp ảnh bằng camera
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap: Bitmap? ->
        bitmap?.let {
            capturedBitmap = it
            selectedImageUri = null // Clear ảnh thư viện nếu có
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(pinkColor)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Tiêu đề
            Text(
                text = "Đánh giá của bạn",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            // Hiển thị sao và điểm
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                repeat(5) { index ->
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star ${index + 1}",
                        tint = if (index < 4) Color.Yellow else Color.Yellow.copy(alpha = 0.5f),
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = "4.5",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Số lượng đánh giá
            Text(
                text = "Số lượng đánh giá:",
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 4.dp),
                textAlign = TextAlign.Start
            )

            // Ô nhập bình luận
            TextField(
                value = commentText,
                onValueChange = { commentText = it },
                placeholder = { Text("Viết bình luận đánh giá") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.White),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nút thêm ảnh - mở dialog chọn nguồn ảnh
            Button(
                onClick = { showImageSourceDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Camera,
                        contentDescription = "Thêm ảnh",
                        tint = Color.Black
                    )
                    Text(
                        text = "Thêm ảnh",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

            // Hiển thị ảnh chụp hoặc ảnh chọn từ thư viện
            Spacer(modifier = Modifier.height(16.dp))

            if (capturedBitmap != null) {
                Image(
                    bitmap = capturedBitmap!!.asImageBitmap(),
                    contentDescription = "Ảnh chụp camera",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            } else if (selectedImageUri != null) {
                val inputStream: InputStream? = context.contentResolver.openInputStream(selectedImageUri!!)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                bitmap?.let {
                    Image(
                        bitmap = it.asImageBitmap(),
                        contentDescription = "Ảnh thư viện",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nút gửi bình luận
            Button(
                onClick = { /* Xử lý gửi bình luận */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "Gửi bình luận",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    // Dialog chọn nguồn ảnh
    if (showImageSourceDialog) {
        AlertDialog(
            onDismissRequest = { showImageSourceDialog = false },
            title = { Text(text = "Chọn nguồn ảnh") },
            text = {
                Column {
                    TextButton(
                        onClick = {
                            showImageSourceDialog = false
                            cameraLauncher.launch(null) // Mở camera chụp ảnh
                        }
                    ) {
                        Text("Chụp ảnh mới")
                    }
                    TextButton(
                        onClick = {
                            showImageSourceDialog = false
                            imagePickerLauncher.launch("image/*") // Mở thư viện ảnh
                        }
                    ) {
                        Text("Chọn từ thư viện")
                    }
                }
            },
            confirmButton = {},
            dismissButton = {}
        )
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
                Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.Black)
            },
            selected = false,
            onClick = { /* Handle profile click */ }
        )

        NavigationBarItem(
            icon = {
                Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color.Black)
            },
            selected = false,
            onClick = { /* Handle settings click */ }
        )
    }
}
