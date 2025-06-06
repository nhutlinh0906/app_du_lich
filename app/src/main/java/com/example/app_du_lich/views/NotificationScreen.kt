package com.example.myapplication.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_du_lich.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(navController: NavController) {
    val pinkColor = Color(0xFFFF69B4)

    val notifications = listOf(
        NotificationItem(
            id = 1,
            profileImage = R.drawable.facebook_logo,
            content = "Chúng tôi nhận thấy có lượt đăng nhập mới từ thiết bị/vị trí mà bạn không hay dùng. Vui lòng xem lại.",
            time = "1 giờ",
            isNew = true,
            hasGroupIcon = true,
            groupIconBackground = Color.Blue
        ),
        NotificationItem(
            id = 2,
            profileImage = R.drawable.profile_pic1,
            content = "Mày làm bạn tao hơi lâu rồi đấy !: Mời các cao nhân giải hộ chữ em lú quá=))) Cre: onpic",
            time = "3 giờ",
            isNew = false,
            hasGroupIcon = true,
            groupIconBackground = Color.Blue
        ),
        NotificationItem(
            id = 3,
            profileImage = R.drawable.room_rental,
            content = "PHÒNG TRỌ BÌNH THẠNH: GÓC PASS PHÒNG 3TR3 (gần ngã 4 phú nhuận)️ - thuận tiện qua phan xích long...",
            time = "14 giờ",
            isNew = false,
            hasGroupIcon = true,
            groupIconBackground = Color.Blue
        ),
        NotificationItem(
            id = 4,
            profileImage = R.drawable.university,
            content = "Đại Học Đúng Học Lại ✅: Giữa Vhu và Hutech thì nên học trường nào nếu ko tính chuyện học phí ạ",
            time = "16 giờ",
            isNew = false,
            hasGroupIcon = true,
            groupIconBackground = Color.Blue
        ),
        NotificationItem(
            id = 5,
            profileImage = R.drawable.default_profile,
            content = "Tin gần đây nhất của bạn có 29 lượt xem trước khi hết hạn. Bạn hãy tạo tin mới nhé.",
            time = "1 tuần",
            isNew = false,
            hasGroupIcon = false,
            groupIconBackground = Color.Transparent
        ),
        NotificationItem(
            id = 6,
            profileImage = R.drawable.default_profile,
            content = "Ghi chú của bạn đã hết hạn. Bạn có thể tạo ghi chú mới.",
            time = "1 tuần",
            isNew = false,
            hasGroupIcon = false,
            groupIconBackground = Color.Transparent
        ),
        NotificationItem(
            id = 7,
            profileImage = R.drawable.default_profile,
            content = "Phòng Trọ Quận Bình Thạnh Giá rẻ 🏠: 🍀CHỈ CÒN PHÒNG DUY NHẤT – DUPLEX CỰC XỊN ☀️ PHÒNG MỚI –...",
            time = "1 tuần",
            isNew = false,
            hasGroupIcon = true,
            groupIconBackground = Color.Blue
        ),
        NotificationItem(
            id = 8,
            profileImage = R.drawable.facebook_logo,
            content = "Bạn có 3 thông báo mới từ nhóm 'Phòng trọ giá rẻ'. Nhấn để xem ngay!",
            time = "2 tuần",
            isNew = false,
            hasGroupIcon = true,
            groupIconBackground = Color.Blue
        ),
        NotificationItem(
            id = 9,
            profileImage = R.drawable.profile_pic1,
            content = "🎓 Thông báo tuyển sinh: Đại học Hutech tuyển sinh đợt 2 năm 2024. Xem chi tiết tại đây!",
            time = "2 tuần",
            isNew = false,
            hasGroupIcon = true,
            groupIconBackground = Color.Blue
        ),
        NotificationItem(
            id = 10,
            profileImage = R.drawable.room_rental,
            content = "🏠 PHÒNG TRỌ MỚI: Phòng trọ full nội thất, giá chỉ 2.5tr/tháng tại quận 7. Liên hệ ngay!",
            time = "3 tuần",
            isNew = false,
            hasGroupIcon = true,
            groupIconBackground = Color.Blue
        ),
        NotificationItem(
            id = 11,
            profileImage = R.drawable.university,
            content = "📚 Khóa học mới: Lập trình Android với Kotlin - Học phí ưu đãi 50% cho sinh viên",
            time = "3 tuần",
            isNew = false,
            hasGroupIcon = true,
            groupIconBackground = Color.Blue
        ),
        NotificationItem(
            id = 12,
            profileImage = R.drawable.default_profile,
            content = "🎉 Chúc mừng! Bạn đã đạt 1000 điểm tích lũy. Đổi ngay voucher giảm giá 50k!",
            time = "1 tháng",
            isNew = false,
            hasGroupIcon = false,
            groupIconBackground = Color.Transparent
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Thông báo",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back click */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = pinkColor
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            item {
                Text(
                    text = "Mới",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }

            val newNotifications = notifications.filter { it.isNew }
            items(newNotifications) { notification ->
                NotificationCard(notification = notification)
            }

            item {
                Text(
                    text = "Trước đó",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }

            val oldNotifications = notifications.filter { !it.isNew }
            items(oldNotifications) { notification ->
                NotificationCard(notification = notification)
            }
        }
    }
}

@Composable
fun NotificationCard(notification: NotificationItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle notification click */ }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            // Profile image
            Image(
                painter = painterResource(id = notification.profileImage),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            // Group icon if applicable
            if (notification.hasGroupIcon) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(notification.groupIconBackground)
                        .align(Alignment.BottomEnd)
                        .padding(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.default_profile),
                        contentDescription = "Group",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = notification.content,
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = notification.time,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }

    Divider(
        color = Color.LightGray.copy(alpha = 0.5f),
        thickness = 0.5.dp,
        modifier = Modifier.padding(start = 88.dp)
    )
}

data class NotificationItem(
    val id: Int,
    val profileImage: Int,
    val content: String,
    val time: String,
    val isNew: Boolean,
    val hasGroupIcon: Boolean,
    val groupIconBackground: Color
)